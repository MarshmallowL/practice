package com.liugs.practice.designpattern.prototypePattern;

import java.io.*;


public class Customer implements Cloneable, Serializable {
    private String name;

    private Address address;

    public Customer shallowClone() {
        Object obj;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.out.println("不支持复制");
            return null;
        }
        return (Customer) obj;
    }

    public Customer deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Customer) ois.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
