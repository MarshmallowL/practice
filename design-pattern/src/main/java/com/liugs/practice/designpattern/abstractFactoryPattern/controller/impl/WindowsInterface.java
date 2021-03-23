package com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.InterfaceController;

public class WindowsInterface implements InterfaceController {
    @Override
    public void controller() {
        System.out.println("this is windows InterfaceController");
    }
}
