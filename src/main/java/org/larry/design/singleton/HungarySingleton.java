package org.larry.design.singleton;

/**
 * 饿汉式
 */
public class HungarySingleton {

    private static HungarySingleton instance ;

    static {
        instance = new HungarySingleton();
    }

    private HungarySingleton(){

    }

    public static HungarySingleton getInstance() {
        return instance;
    }
}
