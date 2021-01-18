package org.larry.design.decorator;

/**
 * 装饰器类
 */
public abstract class PancakeDecorator extends PancakeSaleComponent{

    private PancakeSaleComponent pancakeSaleComponent ;

    public PancakeDecorator(PancakeSaleComponent pancakeSaleComponent) {
        this.pancakeSaleComponent = pancakeSaleComponent;
    }

    public abstract void doSomething() ;


    @Override
    public String buySomething() {
        return pancakeSaleComponent.buySomething();
    }

    @Override
    public int payMoney() {
        return pancakeSaleComponent.payMoney();
    }
}
