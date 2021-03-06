package com.loyofo.test.base.mockito;

import com.loyofo.test.base.mockito.entity.MockObject;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class M5_MockAnswerTest {

    @Test
    public void testAnswer() {
        MockObject mockObject = mock(MockObject.class);
        when(mockObject.intMethod(1)).then(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                return (Integer) invocationOnMock.getArgument(0) + 10;
            }
        });
        // 使用 lambda
        when(mockObject.intMethod(2)).then(call -> (Integer)call.getArgument(0) * 100);
        assertEquals(mockObject.intMethod(1), 11);
        assertEquals(mockObject.intMethod(2), 200);
    }
}
