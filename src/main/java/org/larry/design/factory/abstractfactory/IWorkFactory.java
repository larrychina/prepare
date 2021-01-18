package org.larry.design.factory.abstractfactory;

public abstract class IWorkFactory {


    public void init(){
        System.out.println("数据初始化");
    }

    public abstract IDev createDev();

    public abstract IDebug createDebug() ;
}
