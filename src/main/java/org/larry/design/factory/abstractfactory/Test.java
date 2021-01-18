package org.larry.design.factory.abstractfactory;

public class Test {
    public static void main(String[] args) {
        IWorkFactory factory = new JavaWorkerFactory() ;
        IDebug debug = factory.createDebug();
        IDev dev = factory.createDev();
        debug.debug();
        dev.dev();
    }
}
