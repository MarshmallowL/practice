package com.liugs.practice.designpattern.proxyPattern;

import com.liugs.practice.designpattern.proxyPattern.dao.EmpDao;
import com.liugs.practice.designpattern.proxyPattern.dao.IUserDao;
import com.liugs.practice.designpattern.proxyPattern.dao.impl.UserDao;
import com.liugs.practice.designpattern.proxyPattern.proxy.CglibProxyFactory;
import com.liugs.practice.designpattern.proxyPattern.proxy.ProxyFactory;
import com.liugs.practice.designpattern.proxyPattern.proxy.UserDaoProxy;
import org.junit.Test;

public class ProxyPatternTest {
    @Test
    public void testStaticProxy(){
        IUserDao userDao = new UserDao();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }

    @Test
    public void testJdkDynamicProxy(){
        IUserDao userDao = new UserDao();
        System.out.println(userDao.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }

    @Test
    public void testCglibDynamicProxy(){
        EmpDao empDao = new EmpDao();
        EmpDao proxy = (EmpDao) new CglibProxyFactory(empDao).getInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}