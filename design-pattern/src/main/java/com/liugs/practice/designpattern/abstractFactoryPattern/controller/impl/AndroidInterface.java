package com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.InterfaceController;

public class AndroidInterface implements InterfaceController {
    @Override
    public void controller() {
        System.out.println("this is android InterfaceController");
    }
}
