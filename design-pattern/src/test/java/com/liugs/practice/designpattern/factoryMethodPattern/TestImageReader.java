package com.liugs.practice.designpattern.factoryMethodPattern;

import com.liugs.practice.designpattern.factoryMethodPattern.factory.ImageFactory;
import com.liugs.practice.designpattern.factoryMethodPattern.factory.impl.GifFactory;
import com.liugs.practice.designpattern.factoryMethodPattern.reader.ImageReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestImageReader {
    @Value("${imageReader.class}")
    private String readerClass;

    //简单测试工厂方法模式
    @Test
    public void test1(){
        ImageFactory factory = new GifFactory();
        ImageReader reader = factory.createImageReader();
        reader.read();
    }

    //通过配置文件配置需要使用的图片解析器，用反射获取工厂方法
    @Test
    public void test2(){
        try {
            System.out.println(readerClass);
            String cName = readerClass;
            Class c = Class.forName(cName);
            ImageFactory factory = (ImageFactory) c.newInstance();
            ImageReader reader = factory.createImageReader();
            reader.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //重载工厂方法测试
    @Test
    public void test3(){
        ImageFactory factory = new GifFactory();
        ImageReader reader = factory.createImageReader("gif");
        reader.read();
    }




}
