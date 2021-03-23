package com.liugs.practice.designpattern.factoryMethodPattern.factory.impl;

import com.liugs.practice.designpattern.factoryMethodPattern.factory.ImageFactory;
import com.liugs.practice.designpattern.factoryMethodPattern.reader.ImageReader;
import com.liugs.practice.designpattern.factoryMethodPattern.reader.impl.GifReader;
import com.liugs.practice.designpattern.factoryMethodPattern.reader.impl.JpgReader;

public class GifFactory implements ImageFactory {
    @Override
    public ImageReader createImageReader() {
        return new GifReader();
    }

    @Override
    public ImageReader createImageReader(String type) {
        if ("gif".equals(type)){
            return new GifReader();
        }
        return new JpgReader();
    }
}
