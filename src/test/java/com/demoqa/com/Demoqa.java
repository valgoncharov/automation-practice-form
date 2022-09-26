package com.demoqa.com;

import org.junit.jupiter.api.*;

public class Demoqa {

    @BeforeAll
    static void configure(){
        System.out.println("beforeAll");
    }
    @AfterAll
    static void tearDown(){
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEachTest(){
        System.out.println("beforeEchTest");
    }
    @AfterEach
    void afterEachTest(){
        System.out.println("afterEach");
    }

    @Test
    void firstTest(){
        Assertions.assertTrue(3>2);
    }
    @Test
    void firstTest1(){
        System.out.println("test01");
    }
}
