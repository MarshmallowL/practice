package com.liugs.practice.juc.cf;

import lombok.Data;

/**
 * @author liugs
 * @createTime 2021/3/31 22:43
 */
@Data
public class PhoneVO {
    private String phoneNum;
    private String operator;
    private String city;

    public PhoneVO(String phoneNum, String operator, String city) {
        this.phoneNum = phoneNum;
        this.operator = operator;
        this.city = city;
    }

    public PhoneVO() {
    }
}
