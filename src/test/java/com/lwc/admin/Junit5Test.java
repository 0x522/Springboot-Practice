package com.lwc.admin;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("junit5的测试")
public class Junit5Test {

    @Disabled
    @DisplayName("junit5方法的测试1.1")
    @Test
    void testDisplayName2() {
        System.out.println(2);

    }

    @DisplayName("junit5方法的测试1")
    @Test
    void testDisplayName() {
        System.out.println(1);

    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testDisplayName3() throws InterruptedException {
        Thread.sleep(499);

    }

    @Test
    void testSimpleAssertions() {
        int cal = cal(2, 3);
        assertEquals(5, cal);

    }

    int cal(int a, int b) {
        return a + b;

    }


    @BeforeEach
    void testBefore() {
        System.out.println("测试马上开始了");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("测试整体马上开始了");
    }

    @AfterEach
    void testAfter() {
        System.out.println("测试结束了");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("测试整体结束了");
    }


}
