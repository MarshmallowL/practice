package com.liugs.practice.designpattern.abstractFactoryPattern.factory.impl;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.InterfaceController;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.OperationController;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl.AndroidInterface;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl.AndroidOperation;
import com.liugs.practice.designpattern.abstractFactoryPattern.factory.GameSystemFactory;

public class AndroidSystemFactory implements GameSystemFactory {
    @Override
    public OperationController genOperationController() {
        return new AndroidOperation();
    }

    @Override
    public InterfaceController genInterfaceController() {
        return new AndroidInterface();
    }
}
