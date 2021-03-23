package com.liugs.practice.designpattern.factoryMethodPattern.factory;

import com.liugs.practice.designpattern.factoryMethodPattern.reader.ImageReader;

public interface ImageFactory {
    ImageReader createImageReader();

    ImageReader createImageReader(String type);
}
