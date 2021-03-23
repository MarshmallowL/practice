package com.liugs.practice.designpattern.proxyPattern.proxy;

import com.liugs.practice.designpattern.proxyPattern.dao.EmpDao;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {
    private EmpDao empDao;

    public CglibProxyFactory(EmpDao empDao) {
        this.empDao = empDao;
    }

    public Object getInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(empDao.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理开始");
        Object retVal = method.invoke(empDao,objects);
        System.out.println("cglib动态代理结束");
        return retVal;
    }
}
