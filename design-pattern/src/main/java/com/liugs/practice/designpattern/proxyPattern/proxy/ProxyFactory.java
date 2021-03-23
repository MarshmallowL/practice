package com.liugs.practice.designpattern.proxyPattern.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("动态代理开始事务。。。");
                    Object retVal = method.invoke(target,args);
                    System.out.println("动态代理提交事务。。。");
                    return retVal;
                });
    }
}
