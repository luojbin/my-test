package com.loyofo.test.base.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class T3_AssertTest {

    @Test
    public void testEquals() {
        assertEquals("123", "456");
    }

    @Test
    public void testEquals2() {
        assertEquals("自定义错误信息", "123", "456");
    }

    @Test
    public void testArrayEquals2() {
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 4});
    }

    @Test
    public void testEquals3() {
        String a = "123";
        String b = new String("123");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        assertEquals(a, b);


    }

    @Test
    public void testSame() {
        String a = "123";
        String b = new String("123");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        assertSame(a, b);
    }
}
