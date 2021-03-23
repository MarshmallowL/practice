package com.liugs.practice.designpattern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DesignPatternJavaApplicationTests {

    @Test
    public void contextLoads() {
        Student student = new Student();
        List<Student> list = new ArrayList<>();
        student.setId("1");
        list.add(student);

        Map<String,String> map = list.stream().collect(Collectors.toMap(Student::getId, Student::getName,(k1, k2) -> k1));
//        System.out.println(map.get("1").orElse("hello"));
    }

    public static void main(String[] args) {
        //模拟查回来的数据
        List<Student> stuList = new ArrayList<>();
        Student student = new Student();
        student.setName("1");
        stuList.add(student);

        //转换为Map<id,name>
        Map<String,Optional<String>> map = stuList.stream().collect(Collectors.toMap(Student::getId,e -> Optional.ofNullable(e.getName()),(v1,v2) -> v2));

    }

    public List<Student> init(){
        List<Student> stuList = new ArrayList<>();
        Student student = new Student();
        student.setId("1");
        stuList.add(student);
        return stuList;
    }

}
