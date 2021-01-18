package org.larry.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DynamicsProxy implements InvocationHandler {

    private IProxyDev target ;

    public IProxyDev getInstance(IProxyDev proxyTarget){
        this.target = proxyTarget ;
        Class<?> clazz = target.getClass() ;
        return (IProxyDev) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    public void before(){
        System.out.println("动态代理--需求.......");
    }

    public void after(){
        System.out.println("动态代理--测试........");
    }

    public static void main(String[] args) {
        ProxyDevDeveloper dev = new ProxyDevDeveloper();
        IProxyDev proxyDev = new DynamicsProxy().getInstance(dev);
        proxyDev.dev();
    }
}
