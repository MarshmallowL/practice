package com.liugs.practice.designpattern.singletonPattern.eager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 静态内部类 实现单例模式
 */
public class IoDHSingleton {
    private static IoDHSingleton singleton = null;

    private List<String> serverList;

    private IoDHSingleton() {
        serverList = new ArrayList<>();
    }

    public static IoDHSingleton getSingleton() {
        return HolderClass.ioDHSingleton;
    }

    private static class HolderClass {
        private final static IoDHSingleton ioDHSingleton = new IoDHSingleton();
    }

    public void addServer(String server) {
        serverList.add(server);
    }

    public void removeServer(String server) {
        serverList.remove(server);
    }

    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return serverList.get(i);
    }
}
