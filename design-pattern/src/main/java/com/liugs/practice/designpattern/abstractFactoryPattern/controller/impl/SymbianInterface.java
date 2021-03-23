package com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.InterfaceController;

public class SymbianInterface implements InterfaceController {
    @Override
    public void controller() {
        System.out.println("this is symbian InterfaceController");
    }
}
