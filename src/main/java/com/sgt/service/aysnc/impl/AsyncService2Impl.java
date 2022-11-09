/*
 * Project: sgtSpringBootDemo
 *
 * File Created at 2022-11-07
 *
 * Copyright 2012-2015 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package com.sgt.service.aysnc.impl;

import com.sgt.service.aysnc.AsyncService2;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author sungt
 * @version V1.0
 * @since 2022-11-07 17:03
 */
@Service
public class AsyncService2Impl implements AsyncService2 {

    @Resource
    @Qualifier(value = "taskExecutor")
    private ThreadPoolTaskExecutor taskExecutor;
    @Resource
    @Qualifier(value = "taskExecutor2")
    private ThreadPoolTaskExecutor taskExecutor2;

    @Override
    public void testException() throws ExecutionException, InterruptedException {
        taskExecutor.execute(() -> {
            System.out.println("execute进入了task方法！！！");
            int i = 1 / 0;
        });

        Future<?> submit = taskExecutor.submit(() -> {
            System.out.println("submit进入了task方法！！！");
            int i = 1 / 0;
        });
        submit.get();
    }

    @Override
    public void testException2() {
        taskExecutor.execute(() -> {
            try {
                System.out.println("execute进入了task方法！！！");
                int i = 1 / 0;
            } catch (Exception e) {
                System.out.println("使用了try -catch 捕获异常" + e);
            }
        });

        taskExecutor.submit(() -> {
            try {
                System.out.println("submit进入了task方法！！！");
                int i = 1 / 0;
            } catch (Exception e) {
                System.out.println("使用了try -catch 捕获异常" + e);
            }
        });
    }

    @Override
    public void testException3() throws InterruptedException {
        // submit无提示
        taskExecutor2.submit(() -> {
            System.out.println("submit进入了task方法！！！");
            int i = 1 / 0;
        });

        Thread.sleep(1000);
        System.out.println("==================为检验打印结果，1秒后执行execute方法");

        // execute 方法被线程工厂factory 的UncaughtExceptionHandler捕捉到异常
        taskExecutor2.execute(() -> {
            System.out.println("execute进入了task方法！！！");
            int i = 1 / 0;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        applyToEither();
    }

    private static void runAsync() {
        Runnable runnable = () -> System.out.println("执行无返回结果的异步任务");
        CompletableFuture.runAsync(runnable);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行有返回值的异步任务");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "你好 2022";
        });
        String result = future.join();
        System.out.println(result);

    }

    private static void joinAndGet() {
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });

        future2.join();
    }

    private static void whenComplete() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if (new Random().nextInt(10) % 2 == 0) {
                int i = 12 / 0;
            }
            System.out.println("执行结束！");
            return "test";
        });

        future.whenComplete((t, action) -> System.out.println(t + " 执行完成！"));

        // 异常时执行
        future.exceptionally(t -> {
            System.out.println("执行失败：" + t.getMessage());
            return "异常xxxx";
        }).join();
    }

    private static void thenApply(){
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = 100;
            System.out.println("一阶段：" + result);
            return result;
        }).thenApply(number -> {
            int result = number * 3;
            System.out.println("二阶段：" + result);
            return result;
        });
    }

    private static void thenCompose(){
        CompletableFuture<Integer> future = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(30);
                    System.out.println("第一阶段：" + number);
                    return number;
                }
            })
            .thenCompose(new Function<Integer, CompletionStage<Integer>>() {
                @Override
                public CompletionStage<Integer> apply(Integer param) {
                    return CompletableFuture.supplyAsync(new Supplier<Integer>() {
                        @Override
                        public Integer get() {
                            int number = param * 2;
                            System.out.println("第二阶段：" + number);
                            return number;
                        }
                    });
                }
            });
    }

    private static void thenAccept(){
        CompletableFuture<Void> future = CompletableFuture
            .supplyAsync(() -> {
                int number = new Random().nextInt(10);
                System.out.println("第一阶段：" + number);
                return number;
            }).thenAccept(number ->
                System.out.println("第二阶段：" + number * 5));
    }

    //thenAcceptBoth 函数的作用是，当两个 CompletionStage 都正常完成计算的时候，就会执行提供的action消费两个异步的结果
    private static void thenAcceptBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> futrue1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(3) + 1;
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第一阶段：" + number);
                return number;
            }
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int number = new Random().nextInt(3) + 1;
                try {
                    TimeUnit.SECONDS.sleep(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第二阶段：" + number);
                return number;
            }
        });

        futrue1.thenAcceptBoth(future2, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer x, Integer y) {
                System.out.println("最终结果：" + (x + y));
            }
        });

        future2.get();
    }

    //thenRun 也是对线程任务结果的一种消费函数，与thenAccept不同的是，thenRun 会在上一阶段 CompletableFuture 计算完成的时候执行一个Runnable，Runnable并不使用该 CompletableFuture 计算的结果。
    private static void thenRun(){
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            int number = new Random().nextInt(10);
            System.out.println("第一阶段：" + number);
            return number;
        }).thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("thenRun 执行");
            }
        });
    }

    //thenCombine 方法，合并两个线程任务的结果，并进一步处理。
    private static void thenCombine(){
        CompletableFuture<Integer> future1 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(10);
                    System.out.println("第一阶段：" + number);
                    return number;
                }
            });
        CompletableFuture<Integer> future2 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(10);
                    System.out.println("第二阶段：" + number);
                    return number;
                }
            });
        CompletableFuture<Integer> result = future1
            .thenCombine(future2, new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer x, Integer y) {
                    return x + y;
                }
            });
    }

    //两个线程任务相比较，先获得执行结果的，就对该结果进行下一步的转化操作。
    private static void applyToEither() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(10);
                    System.out.println("第一阶段start：" + number);
                    try {
                        TimeUnit.SECONDS.sleep(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第一阶段end：" + number);
                    return number;
                }
            });
        CompletableFuture<Integer> future2 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(10);
                    System.out.println("第二阶段start：" + number);
                    try {
                        TimeUnit.SECONDS.sleep(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第二阶段end：" + number);
                    return number;
                }
            });

        future1.applyToEither(future2, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                System.out.println("最快结果：" + number);
                return number * 2;
            }
        });
        future1.get();
    }

    //两个线程任务相比较，先获得执行结果的，就对该结果进行下一步的消费操作。
    private static void acceptEither() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(10) + 1;
                    try {
                        TimeUnit.SECONDS.sleep(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第一阶段：" + number);
                    return number;
                }
            });

        CompletableFuture<Integer> future2 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(10) + 1;
                    try {
                        TimeUnit.SECONDS.sleep(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第二阶段：" + number);
                    return number;
                }
            });

        future1.acceptEither(future2, new Consumer<Integer>() {
            @Override
            public void accept(Integer number) {
                System.out.println("最快结果：" + number);
            }
        });
        future1.get();
        future2.get();
    }

    //两个线程任务相比较，有任何一个执行完成，就进行下一步操作，不关心运行结果。
    private static void runAfterEither(){
        CompletableFuture<Integer> future1 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(5);
                    try {
                        TimeUnit.SECONDS.sleep(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第一阶段：" + number);
                    return number;
                }
            });

        CompletableFuture<Integer> future2 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    int number = new Random().nextInt(5);
                    try {
                        TimeUnit.SECONDS.sleep(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第二阶段：" + number);
                    return number;
                }
            });

        future1.runAfterEither(future2, new Runnable() {
            @Override
            public void run() {
                System.out.println("已经有一个任务完成了");
            }
        }).join();
    }

    //两个线程任务相比较，两个全部执行完成，才进行下一步操作，不关心运行结果。
    private static void runAfterBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第一阶段：1");
                    return 1;
                }
            });

        CompletableFuture<Integer> future2 = CompletableFuture
            .supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第二阶段：2");
                    return 2;
                }
            });

        future1.runAfterBoth(future2, new Runnable() {
            @Override
            public void run() {
                System.out.println("上面两个任务都执行完成了。");
            }
        });

        future1.get();
        future2.get();
    }

    //allOf方法用来实现多 CompletableFuture 的同时返回。
    private static void allOf() throws ExecutionException, InterruptedException {
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1完成");
            return 100;
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2完成");
            return "abc";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future3完成");
            return "123abc";
        });
        CompletableFuture.allOf(future1,future2,future3).thenRun(()->{
            System.out.println("All done!");
        });

        CompletableFuture<Object> f = CompletableFuture.anyOf(future1,future2,future3);
        System.out.println("结果："+f.get());

        TimeUnit.SECONDS.sleep(5);
    }

    private static void futureTask() throws ExecutionException, InterruptedException {
        Task task = new Task();
        //构建futureTask
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        //作为Runnable入参
        new Thread(futureTask).start();

        System.out.println("主程序继续执行。。");

        System.out.println("task运行结果："+futureTask.get());
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算");
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
            // 模拟业务执行时间
            Thread.sleep(1000);
            return sum;
        }
    }
}

