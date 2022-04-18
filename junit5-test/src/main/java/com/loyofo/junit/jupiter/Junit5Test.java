package com.loyofo.junit.jupiter;

import org.junit.jupiter.api.*;

@DisplayName("接口测试分组")
public class Junit5Test {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("原来的 @BeforeClass, 在该类的所有测试方法之前， 只执行一次");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("原来的 @AfterClass, 在该类的所有测试方法之后， 只执行一次");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("原来的 @Before, 在每个测试方法前都执行一次");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("原来的 @After, 在每个测试方法后都执行一次");
    }

    @Test
    @Disabled
    @DisplayName("第0个测试")
    public void test0() {
        System.out.println("第01个测试。。。被跳过， 不应该执行");
    }

    @Test
    @Disabled("这个是什么")
    @DisplayName("第1个测试")
    public void test1() {
        System.out.println("第1个测试。。。");
    }

    @Test
    @DisplayName("第2个测试")
    public void test2() {
        System.out.println("第2个测试。。。");
    }

    @Test
    @DisplayName("第3个测试")
    public void test3() {
        System.out.println("第3个测试。。。");
    }

    @DisplayName("第4个测试")
    @Test
    public void test4() {
        System.out.println("第4个测试。。。");
    }

    @Nested
    @DisplayName("内嵌测试")
    class NestedTest {
        @DisplayName("第5个测试,内嵌")
        @Test
        public void test5() {
            System.out.println("第5个测试。。。");
        }

        @DisplayName("第6个测试，内嵌")
        @Test
        public void test6() {
            System.out.println("第6个测试。。。");
        }
    }
}
