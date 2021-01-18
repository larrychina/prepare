package org.larry.design.singleton;

/**
 * 懒加载，double check模式
 */
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance ;

    private LazyDoubleCheckSingleton(){

    }
    public static LazyDoubleCheckSingleton getInstance() {
        if(instance == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(instance == null){
                    instance = new LazyDoubleCheckSingleton() ;
                }
            }
        }
        return instance ;
    }
}
