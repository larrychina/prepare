package org.larry.design.adapter;

/**
 * 抽象适配器接口
 */
public abstract class AbstactAdapter extends LoginService implements ILoginAdapter {

    @Override
    public abstract boolean support(Object object);

    public abstract ResultMsg loginForRegist(String username, String password);
}
