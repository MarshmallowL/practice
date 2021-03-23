package com.liugs.practice.designpattern.abstractFactoryPattern.factory;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.InterfaceController;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.OperationController;

public interface GameSystemFactory {
    OperationController genOperationController();

    InterfaceController genInterfaceController();
}
