package org.larry.design.proxy;

/**
 * 静态代理者
 */
public class StaticProxy implements IProxyDev {

    ProxyDevDeveloper developer ;

    public StaticProxy() {
//        this.developer = developer;
        this.developer = new ProxyDevDeveloper();
    }

    @Override
    public void dev() {
        before();
        developer.dev();
        after();
    }

    private void after() {
        System.out.println("静态代理--测试.......");
    }

    private void before() {
        System.out.println("静态代理--需求....");
    }

    public static void main(String[] args) {
        IProxyDev staticProxy = new StaticProxy();
        staticProxy.dev();
    }
}
