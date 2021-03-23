package com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.OperationController;

public class AndroidOperation implements OperationController {
    @Override
    public void controller() {
        System.out.println("this is android operationController");
    }
}
