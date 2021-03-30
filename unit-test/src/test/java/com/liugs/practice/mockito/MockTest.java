package com.liugs.practice.mockito;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

/**
 * @author liugs
 * @createTime 2021/3/27 14:08
 * 来源：
 * https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#mockito2
 */
public class MockTest {
    ArrayList mockedList;

    @Before
    public void init() {
        mockedList = mock(ArrayList.class);
    }

    /**
     * mock对象
     */
    @Test
    public void test1() {
        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 打桩，即设定输入值和返回结果
     */
    @Test
    public void test2() {
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(1));

        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }

    /**
     * 输入参数匹配
     * 可用anyX()之类的方法，如anyInt:输入任何整形
     * 也可使用ArgumentMatcher的实现方法，支持lambda表达式
     */
    @Test
    public void test3() {
        when(mockedList.get(anyInt())).thenReturn("element");
        when(mockedList.addAll(argThat(list -> list.size() > 2))).thenReturn(false);

        boolean res = mockedList.addAll(Arrays.asList(1, 2, 3, 45, 6));
        System.out.println(res);
        verify(mockedList).addAll(Arrays.asList(1, 2, 3, 45, 6));

        System.out.println(mockedList.get(999));

        verify(mockedList).get(anyInt());
    }

    /**
     * 验证调用次数
     * 有atMostOnce()、atLeastOnce()
     * 也可通过atMost(int) 传入想要被调用的次数
     */
    @Test
    public void test4() {
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        verify(mockedList, never()).add("never happened");

        verify(mockedList, atMostOnce()).add("once");
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }


    /**
     * 对返回值为空的方法进存根
     */
    @Test
    public void test5() {
        doThrow(new RuntimeException()).when(mockedList).clear();
        mockedList.clear();
    }

    /**
     * 按顺序验证
     */
    @Test
    public void test6() {
        mockedList.add("was added first");
        mockedList.add("was added second");

        InOrder inOrder = inOrder(mockedList);

        inOrder.verify(mockedList).add("was added first");
        inOrder.verify(mockedList).add("was added second");

        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        firstMock.add("was called first");
        secondMock.add("was called second");

        InOrder inOrder1 = inOrder(firstMock, secondMock);
        inOrder1.verify(firstMock).add("was called first");
        inOrder1.verify(secondMock).add("was called second");
    }

    /**
     * 确保没有和其他mock交互
     */
    @Test
    public void test7() {
        List mockTwo = mock(List.class);
        mockedList.add("one");

        verify(mockedList).add("one");
        verify(mockedList, never()).add("two");

        verifyZeroInteractions(mockTwo);
    }

    /**
     * 发现多余的调用
     * 作为一个比较方便的断言测试，不应该被使用在每个测试用例中
     * 只在相关情况下使用，避免过度指定、难以维护的测试
     */
    @Test
    public void test8() {
        mockedList.add("one");

        mockedList.add("two");

        verify(mockedList).add("one");

        //mock了two，但是实际没有使用到
        verifyNoMoreInteractions(mockedList);
    }

    /**
     * 连续存根
     * ！！！如果不是链式调用，后续的存根会覆盖之前的存根
     */
    @Test
    public void test10() {
        when(mockedList.add("one"))
                .thenReturn(false, true, false);
        mockedList.add("one");
        System.out.println(mockedList.add("one"));
        System.out.println(mockedList.add("one"));
        System.out.println(mockedList.add("one"));
        System.out.println(mockedList.add("one"));
    }

    /**
     * 使用Answer接口存根
     * 一般使用thenReturn或者thenThrow即可
     */
    @Test
    public void test11() {
        when(mockedList.add("one"))
                .thenAnswer(x -> {
                    Object[] args = x.getArguments();
                    System.out.println("call with arguments：" + Arrays.toString(args));
                    return true;
                });
        System.out.println(mockedList.add("one"));
    }

    /**
     * doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() 系列方法
     * 存根返回为void的方法
     * 在spy对象上存根
     * 对同一个方法多次存根，在测试中模拟更改的行为
     */
    @Test
    public void test12() {
        doThrow(new RuntimeException()).when(mockedList).clear();
        mockedList.clear();
    }

    /**
     * 创建真实对象的spy
     * spy是真实实例的一个副本，因此在spy上的操作没有存根时，是不会对原始实例的造成影响
     */
    @Test
    public void test13() {
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));

        System.out.println(spy.size());

        verify(spy).add("one");
        verify(spy).add("two");

        //当使用spy时，考虑使用doReturn|Answer|Throw()系列方法来存根
//        when(spy.get(0)).thenReturn("foo");
//        doReturn("foo").when(spy).get(0);
//        System.out.println(spy.get(0));
    }

    /**
     * 改变默认的返回值
     * TODO 不是很懂实际作用
     */
    @Test
    public void test14() {
        List list = mock(List.class, RETURNS_SMART_NULLS);
        List list2 = mock(List.class, x -> {
            System.out.println(Arrays.toString(x.getArguments()));
            return false;
        });
    }

    /**
     * TODO
     * 在verify后验证实际参数
     * https://javadoc.io/static/org.mockito/mockito-core/3.8.0/org/mockito/Mockito.html#captors
     */
    @Test
    public void test15() {
        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        verify(mockedList).add(argument.capture());
        Assert.assertEquals("one", argument.getValue());
    }

    /**
     * 适用于无法轻易改动的第三方代码、遗留代码重构
     */
    @Test
    public void test16() {
        //使用spy方法创建一个部分模拟
        List list = spy(new LinkedList());
        //mock对象，通过thenCallRealMethod()方法实现部分模拟
        List list1 = mock(List.class);
        when(list1.add("one")).thenCallRealMethod();
    }

    /**
     * reset()方法，会清空所有存根和相互作用
     * 不建议使用
     */
    @Test
    public void test17() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(10);
        mock.add(1);
        reset(mock);
        System.out.println(mock.size());
    }

    /**
     * 引入org.mockito.BDDMockito.*
     * BDD别名
     */
    @Test
    public void test19() {
        //given
        given(mockedList.add("one")).willReturn(true);
        //when
        boolean res = mockedList.add("one");
        //then
        Assert.assertTrue(res);
    }

    /**
     * 20
     * 序列化mock
     * 该行为是为具有不可靠外部依赖关系的BDD规范的特定用例实现的。
     */
    @Test
    public void test20() {
        List serializableMock = mock(List.class, withSettings().serializable());
    }

    /**
     * 21
     * @Capter 简化ArgumentCaptor的创建, 捕获泛型参数时可以避免编译器警告
     * @Spy 替代spy(Object)
     * @InjectMocks 向测试对象自动注入mock或者spy字段
     *
     */

    /**
     * 22
     * 超时验证，避免使用
     */

    /**
     * 23 自动实例化 @Spies、@InjectMocks
     */

    /**
     * 24 使用一行代码存根
     */

    /**
     * 25
     * 验证时忽略存根
     * verifyNoMoreInteractions(ignoreStubs())
     */

}
