package com.liugs.practice.designpattern.abstractFactoryPattern.factory.impl;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.InterfaceController;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.OperationController;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl.WindowsInterface;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl.WindowsOperation;
import com.liugs.practice.designpattern.abstractFactoryPattern.factory.GameSystemFactory;

public class WindowsSystemFactory implements GameSystemFactory {
    @Override
    public OperationController genOperationController() {
        return new WindowsOperation();
    }

    @Override
    public InterfaceController genInterfaceController() {
        return new WindowsInterface();
    }
}
