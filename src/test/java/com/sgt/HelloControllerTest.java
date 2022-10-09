package com.sgt;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

import com.jayway.restassured.RestAssured;
import com.sgt.bo.TestBO;
import com.sgt.bo.TestEvent;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class HelloControllerTest {
    int port;
    @Resource
    private ApplicationEventPublisher publisher;


    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void testHello() throws Exception {
        when().get("/").then()
                .body(is("Hello World!"));
    }

    @Test
    public void testCalc() throws Exception {
        given().param("left", 100)
                .param("right", 200)
                .get("/calc")
                .then()
                .body("left", is(100))
                .body("right", is(200))
                .body("answer", is(300));
    }

    @Test
    public void testEvent() throws Exception {
        TestBO a = new TestBO();
        a.setA(1);
        a.setC(3);
        TestEvent event = new TestEvent();
        event.setEventId(String.valueOf(UUID.randomUUID()));
        event.setTestBO(a);
        publisher.publishEvent(event);
        System.out.println("主线程");
    }


}