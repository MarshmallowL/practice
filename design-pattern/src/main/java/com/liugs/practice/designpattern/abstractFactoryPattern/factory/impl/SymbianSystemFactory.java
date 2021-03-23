package com.liugs.practice.designpattern.abstractFactoryPattern.factory.impl;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.InterfaceController;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.OperationController;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl.SymbianOperation;
import com.liugs.practice.designpattern.abstractFactoryPattern.factory.GameSystemFactory;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.impl.SymbianInterface;

public class SymbianSystemFactory implements GameSystemFactory {
    @Override
    public OperationController genOperationController() {
        return new SymbianOperation();
    }

    @Override
    public InterfaceController genInterfaceController() {
        return new SymbianInterface();
    }
}
