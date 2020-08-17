package org.larry.normal.classloader;

public class SingletonDemo {

    private static SingletonDemo instance = new SingletonDemo();
    private static int count1;
    private static int count2 = 0;
    private int count3;

    public SingletonDemo() {
        count1++;
        count2++;
    }

    {
        count3++;
    }

    public static SingletonDemo getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonDemo instance = SingletonDemo.getInstance();

      //  SingletonDemo singletonDemo = new SingletonDemo() ;
        System.out.println("count1=" + count1);
        System.out.println("count2=" + count2);
        System.out.println("count3=" + instance.count3);
    }
}
