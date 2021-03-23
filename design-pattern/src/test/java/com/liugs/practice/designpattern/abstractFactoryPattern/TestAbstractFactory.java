package com.liugs.practice.designpattern.abstractFactoryPattern;

import com.liugs.practice.designpattern.abstractFactoryPattern.controller.InterfaceController;
import com.liugs.practice.designpattern.abstractFactoryPattern.controller.OperationController;
import com.liugs.practice.designpattern.abstractFactoryPattern.factory.GameSystemFactory;
import com.liugs.practice.designpattern.abstractFactoryPattern.factory.impl.WindowsSystemFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAbstractFactory {
    @Test
    public void test1(){
        GameSystemFactory factory = new WindowsSystemFactory();
        InterfaceController ic = factory.genInterfaceController();
        OperationController oc = factory.genOperationController();

        ic.controller();
        oc.controller();
    }
}
