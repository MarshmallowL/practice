package com.liugs.practice.designpattern.factoryMethodPattern.factory.impl;

import com.liugs.practice.designpattern.factoryMethodPattern.reader.ImageReader;
import com.liugs.practice.designpattern.factoryMethodPattern.factory.ImageFactory;
import com.liugs.practice.designpattern.factoryMethodPattern.reader.impl.GifReader;
import com.liugs.practice.designpattern.factoryMethodPattern.reader.impl.JpgReader;

public class JpgFactory implements ImageFactory {
    @Override
    public ImageReader createImageReader() {
        return new JpgReader();
    }

    @Override
    public ImageReader createImageReader(String type) {
        if ("jpg".equals(type)){
            return new JpgReader();
        }
        return new GifReader();
    }
}
