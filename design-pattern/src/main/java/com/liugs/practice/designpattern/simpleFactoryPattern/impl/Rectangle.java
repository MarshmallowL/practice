package com.liugs.practice.designpattern.simpleFactoryPattern.impl;

import com.liugs.practice.designpattern.simpleFactoryPattern.Painting;

public class Rectangle implements Painting {
    @Override
    public void draw() {
        System.out.println("画一个方形");
    }

    @Override
    public void erase() {
        System.out.println("擦除一个方形");
    }
}
