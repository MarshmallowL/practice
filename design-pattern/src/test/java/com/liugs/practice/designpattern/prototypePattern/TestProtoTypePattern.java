package com.liugs.practice.designpattern.prototypePattern;

import org.junit.Test;

import java.io.IOException;

public class TestProtoTypePattern {
    //浅克隆测试
    @Test
    public void testShallowClone(){
        Customer customer = new Customer();
        Address address = new Address();
        address.setAddressName("测试地址1");
        customer.setAddress(address);
        customer.setName("测试人员1");

        Customer copyCustomer = customer.shallowClone();

        System.out.println("is same object : " + (customer == copyCustomer) );
        System.out.println(customer.getName().equals(copyCustomer.getName()));
        System.out.println(customer.getAddress() == copyCustomer.getAddress());
    }

    //深克隆测试
    @Test
    public void testDeepClone() throws IOException, ClassNotFoundException {
        Customer customer = new Customer();
        Address address = new Address();
        address.setAddressName("测试地址1");
        customer.setAddress(address);
        customer.setName("测试人员1");

        Customer copyCustomer = customer.deepClone();

        System.out.println("is same object : " + (customer == copyCustomer) );
        System.out.println(customer.getName().equals(copyCustomer.getName()));
        System.out.println(customer.getAddress() == copyCustomer.getAddress());
    }
}
