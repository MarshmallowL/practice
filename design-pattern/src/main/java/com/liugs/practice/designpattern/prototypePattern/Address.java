package com.liugs.practice.designpattern.prototypePattern;

import java.io.Serializable;

public class Address implements Serializable {
    private String addressName;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
