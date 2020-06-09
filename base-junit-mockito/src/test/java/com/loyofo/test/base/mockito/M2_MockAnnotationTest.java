package com.loyofo.test.base.mockito;

import com.loyofo.test.base.mockito.entity.MockInterface;
import com.loyofo.test.base.mockito.entity.MockObject;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class M2_MockAnnotationTest {
    @Mock private MockInterface mock;
    @Spy private MockObject spy;

    public M2_MockAnnotationTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockAnnotation() {
        when(mock.strMethod("@Mock")).thenReturn("注入成功, 可以调用");
        assertEquals(mock.strMethod("@Mock"), "注入成功, 可以调用");

        when(spy.strMethod("@Mock")).thenReturn("注入成功, 可以调用");
        assertEquals(spy.strMethod("@Mock"), "注入成功, 可以调用");
    }
}
