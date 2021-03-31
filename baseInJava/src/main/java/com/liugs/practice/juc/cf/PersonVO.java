package com.liugs.practice.juc.cf;

import lombok.Data;

import java.util.List;

/**
 * @author liugs
 * @createTime 2021/3/31 22:42
 */
@Data
public class PersonVO {
    private String idCard;
    private String name;
    private List<String> phoneNum;

    public PersonVO(String idCard, String name, List<String> phoneNum) {
        this.idCard = idCard;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public PersonVO() {
    }
}
