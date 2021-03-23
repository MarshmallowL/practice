package com.liugs.practice.designpattern.singlePattern;

import com.liugs.practice.designpattern.singletonPattern.eager.EagerSingleton;
import com.liugs.practice.designpattern.singletonPattern.eager.IoDHSingleton;
import com.liugs.practice.designpattern.singletonPattern.eager.LazySingleton;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSinglePattern {

    @Test
    public void testEagerSingleton() {
        EagerSingleton singleton1 = EagerSingleton.getEagerSingleton();
        EagerSingleton singleton2 = EagerSingleton.getEagerSingleton();
        EagerSingleton singleton3 = EagerSingleton.getEagerSingleton();
        if (singleton1 == singleton2 && singleton2 == singleton3) {
            System.out.println("服务器负载均衡具有唯一性！");
        }
        singleton1.addServer("server1");
        singleton1.addServer("server2");
        singleton1.addServer("server3");
        for (int i = 0; i < 10; i++) {
            System.out.println(singleton1.getServer());
        }
    }

    @Test
    public void testLazySingleton(){
        LazySingleton lazySingleton1 = LazySingleton.getLazySingleton();
        LazySingleton lazySingleton2 = LazySingleton.getLazySingleton();
        LazySingleton lazySingleton3 = LazySingleton.getLazySingleton();
        if (lazySingleton1 == lazySingleton2 && lazySingleton2 == lazySingleton3){
            System.out.println("懒汉式——服务器负载均衡具有唯一性！");
        }
    }

    @Test
    public void testIoDHSingleton(){
        IoDHSingleton singleton1 = IoDHSingleton.getSingleton();
        IoDHSingleton singleton2 = IoDHSingleton.getSingleton();
        IoDHSingleton singleton3 = IoDHSingleton.getSingleton();
        if (singleton1 == singleton2 && singleton2 == singleton3) {
            System.out.println("服务器负载均衡具有唯一性！");
        }
    }


}
