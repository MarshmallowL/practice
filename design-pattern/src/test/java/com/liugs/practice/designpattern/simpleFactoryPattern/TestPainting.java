package com.liugs.practice.designpattern.simpleFactoryPattern;

import org.junit.Test;



public class TestPainting {
    @Test
    public void testCircle(){
        try {
            Painting painting = Painting.paintingFactory("rectangle");
            painting.draw();
            painting.erase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
