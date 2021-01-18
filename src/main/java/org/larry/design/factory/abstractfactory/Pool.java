package org.larry.design.factory.abstractfactory;

public abstract class Pool {

    protected Pool(){
        init();
        loadDriver() ;
    }

    private void loadDriver() {
        System.out.println("加载驱动");
    }

    private void init() {
        System.out.println("初始化参数");
    }

    protected abstract void createConnection();
}
