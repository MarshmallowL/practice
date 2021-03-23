package com.liugs.practice.designpattern.proxyPattern.dao.impl;

import com.liugs.practice.designpattern.proxyPattern.dao.IUserDao;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("===========数据保存成功============");
    }
}
