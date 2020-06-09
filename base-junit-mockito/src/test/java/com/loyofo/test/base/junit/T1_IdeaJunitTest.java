package com.loyofo.test.base.junit;

import org.junit.Assert;
import org.junit.Test;

public class T1_IdeaJunitTest {

    @Test
    public void test() {
        System.out.println("idea+junit 测试");
    }

    @Test
    public void testFail() {
        Assert.fail("强制失败");
    }
}
