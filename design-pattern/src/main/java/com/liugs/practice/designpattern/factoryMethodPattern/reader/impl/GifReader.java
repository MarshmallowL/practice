package com.liugs.practice.designpattern.factoryMethodPattern.reader.impl;

import com.liugs.practice.designpattern.factoryMethodPattern.reader.ImageReader;

public class GifReader implements ImageReader {
    @Override
    public void read() {
        System.out.println("this is a GIF Reader");
    }
}
