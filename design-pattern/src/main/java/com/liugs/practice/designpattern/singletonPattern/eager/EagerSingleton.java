package com.liugs.practice.designpattern.singletonPattern.eager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 饿汉式单例模式
 * 类加载时初始化，不能实现延迟加载
 */
public class EagerSingleton {
    private static final EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
        serverList = new ArrayList<>();
    }

    private List<String> serverList = null;

    public void addServer(String server) {
        serverList.add(server);
    }

    public void removeServer(String server) {
        serverList.remove(server);
    }

    public static EagerSingleton getEagerSingleton() {
        return eagerSingleton;
    }

    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }
}
