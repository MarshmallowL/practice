package com.liugs.practice.designpattern.singletonPattern.eager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 懒汉式加载
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton = null;

    private List<String> serverList;

    private LazySingleton() {
        serverList = new ArrayList<>();
    }

    public static LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
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
