package com.liugs.practice.designpattern.simpleFactoryPattern;

import com.liugs.practice.designpattern.simpleFactoryPattern.impl.Rectangle;
import com.liugs.practice.designpattern.simpleFactoryPattern.impl.Circle;
import com.liugs.practice.designpattern.simpleFactoryPattern.impl.Triangle;

public interface Painting {
    static Painting paintingFactory(String shape) throws Exception {
        if ("circle".equals(shape)){
            return new Circle();
        }else if ("triangle".equals(shape)){
            return new Triangle();
        }else if ("rectangle".equals(shape)){
            return new Rectangle();
        }else {
            throw new Exception("不支持的形状");
        }


    }


    void draw();

    void erase();
}
