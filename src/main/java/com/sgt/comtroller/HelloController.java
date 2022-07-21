package com.sgt.comtroller;

import com.sgt.service.aysnc.AysncService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demo")
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Resource
    private AysncService aysncService;

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("/aysnc")
    public void testAysnc() {
        aysncService.testAysnc2();
    }

    /**
     * 异步调用restful
     * 当controller返回值是Callable的时候，springmvc就会启动一个线程将Callable交给TaskExecutor去处理
     * 然后DispatcherServlet还有所有的spring拦截器都退出主线程，然后把response保持打开的状态
     * 当Callable执行结束之后，springmvc就会重新启动分配一个request请求，然后DispatcherServlet就重新
     * 调用和处理Callable异步执行的返回结果， 然后返回视图
     *
     * @return
     */
    @GetMapping("/hello")
    public Callable<String> helloController() {
        log.info(Thread.currentThread().getName() + " 进入helloController方法");
        Callable<String> callable = () -> {
            log.info(Thread.currentThread().getName() + " 进入call方法");
            String say = aysncService.sayHello();
            log.info(Thread.currentThread().getName() + " 从helloService方法返回");
            return say;
        };
        log.info(Thread.currentThread().getName() + " 从helloController方法返回");
        return callable;
    }

    /**
     * 带超时时间的异步请求 通过WebAsyncTask自定义客户端超时间
     *
     * @return
     */
    @GetMapping("/world")
    public WebAsyncTask<String> worldController() {
        log.info(Thread.currentThread().getName() + " 进入helloController方法");

        // 3s钟没返回，则认为超时
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(3000, () -> {
            log.info(Thread.currentThread().getName() + " 进入call方法");
            String say = aysncService.sayHello();
            log.info(Thread.currentThread().getName() + " 从helloService方法返回");
            return say;
        });
        log.info(Thread.currentThread().getName() + " 从helloController方法返回");

        webAsyncTask.onCompletion(() -> log.info(Thread.currentThread().getName() + " 执行完毕"));

        webAsyncTask.onTimeout(() -> {
            log.info(Thread.currentThread().getName() + " onTimeout");
            // 超时的时候，直接抛异常，让外层统一处理超时异常
            throw new TimeoutException("调用超时");
        });
        return webAsyncTask;
    }

    /**
     * 异步调用，异常处理，详细的处理流程见MyExceptionHandler类
     *
     * @return
     */
    @GetMapping("/exception")
    public WebAsyncTask<String> exceptionController() {
        log.info(Thread.currentThread().getName() + " 进入helloController方法");
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                log.info(Thread.currentThread().getName() + " 进入call方法");
                throw new TimeoutException("调用超时!");
            }
        };
        log.info(Thread.currentThread().getName() + " 从helloController方法返回");
        return new WebAsyncTask<>(20000, callable);
    }

    @Data
    static class Result {
        private final int left;
        private final int right;
        private final long answer;
    }

    @RequestMapping("calc")
    Result calc(@RequestParam int left, @RequestParam int right) {
        MapSqlParameterSource source = new MapSqlParameterSource().addValue("left", left).addValue("right", right);
        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
            (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
    }

}
