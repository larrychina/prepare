package org.larry.design.adapter;

/**
 * 扩展登陆适配器接口
 * 目标适配器
 */
public interface ILoginAdapter {

    public boolean support(Object object) ;

    public ResultMsg login(String username,String password ,Object adapter) ;
}
