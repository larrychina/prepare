package org.larry.design.singleton;

/**
 * 懒汉式-静态内部类
 */
public class LazyStaticInnerClassSingleton {



    private LazyStaticInnerClassSingleton(){
        if(SingletonInstance.lazyStaticInnerClassSingleton != null){
            // throw Exception  防止反射破坏单例模式
        }
    }

    // sttic 为了使单例空间共享  final 使方法保证不能被重载
    public static final LazyStaticInnerClassSingleton getInstance(){
        return SingletonInstance.lazyStaticInnerClassSingleton ;
    }
    // 默认不加载
    static class SingletonInstance{
        private static LazyStaticInnerClassSingleton lazyStaticInnerClassSingleton = new LazyStaticInnerClassSingleton();
    }
}
