package org.larry.design.strage;

/**
 * 福利操作策略
 *  针对不同活动模式，处理行为不同
 *
 *  优点：
 *  1，符合开闭原则
 *  2，避免在业务逻辑中使用多重条件转移语句，如if...else 、 switch语句
 *  3，使用策略模式可以提高算法的保密性和安全性
 *
 *  缺点：
 *  1，客户端必须知道所有策略，并且自行决定使用哪个策略类
 *  2，代码中会产生很多策略类，维护成本高
 */
public interface FlCodeOperationStrage {

    public boolean validate() ;

    public boolean lock() ;

    public boolean deduct() ;

    public boolean unLock() ;

}
