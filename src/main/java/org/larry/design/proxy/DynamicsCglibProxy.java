package org.larry.design.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 基于cglib的动态代理
 */
public class DynamicsCglibProxy implements MethodInterceptor {

    private IProxyDev target ;


    public Object getInstance(Class<?> clazz){
        this.target = target ;

        Enhancer enhancer = new Enhancer();
        // 基于哪个类生成代理
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        methodProxy.invokeSuper(o,objects);
        after();
        return null;
    }

    public void before(){
        System.out.println("cglib动态代理--需求.......");
    }

    public void after(){
        System.out.println("cglib动态代理--测试........");
    }


    public static void main(String[] args) {
        DynamicsCglibProxy proxy = new DynamicsCglibProxy() ;
        ProxyDevDeveloper instance = (ProxyDevDeveloper) proxy.getInstance(ProxyDevDeveloper.class);
        instance.dev();
    }
}
