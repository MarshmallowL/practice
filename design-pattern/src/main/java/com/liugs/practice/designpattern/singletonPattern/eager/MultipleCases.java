package com.liugs.practice.designpattern.singletonPattern.eager;

import java.util.List;

/**
 * 单例特殊  多个单例
 */
public class MultipleCases {
    private static List<MultipleCases> multipleCases = null;

    private MultipleCases(){

        System.out.println("初始话 单例");
    }

    private static class ClassHolder{
        MultipleCases case1 = new MultipleCases();
        MultipleCases case2 = new MultipleCases();

    }
}
