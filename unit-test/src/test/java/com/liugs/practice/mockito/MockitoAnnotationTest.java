package com.liugs.practice.mockito;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author liugs
 * @createTime 2021/3/28 20:38
 *
 * TODO 注解如何使用
 */
public class MockitoAnnotationTest extends SampleBaseTestCase{
    @Mock
    private List mockedList;

    @Test
    public void test(@Mock List mockedList){
        when(mockedList.get(0)).thenReturn("123");
        mockedList.add("one");
        verify(mockedList.add("one"));
    }
}

class SampleBaseTestCase{
    private AutoCloseable closeable;

    @Before
    public void openMocks(){
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }


}
