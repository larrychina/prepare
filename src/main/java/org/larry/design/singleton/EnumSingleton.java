package org.larry.design.singleton;

/**
 * 枚举式单例
 * effective java 一书中推荐使用
 */
public enum EnumSingleton {

    INSTANCE;
    private Object data ;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
