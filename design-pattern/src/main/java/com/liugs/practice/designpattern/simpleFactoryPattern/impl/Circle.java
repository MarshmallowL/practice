package com.liugs.practice.designpattern.simpleFactoryPattern.impl;

import com.liugs.practice.designpattern.simpleFactoryPattern.Painting;

public class Circle implements Painting {
    @Override
    public void draw() {
        System.out.println("画一个圆形");
    }

    @Override
    public void erase() {
        System.out.println("擦除一个圆形");
    }
}
