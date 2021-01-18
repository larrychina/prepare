package org.larry.design.decorator;

public class PancakeAddEggDecorator extends PancakeDecorator {

    public PancakeAddEggDecorator(PancakeSaleComponent pancakeSaleComponent) {
        super(pancakeSaleComponent);
    }

    @Override
    public void doSomething() {

    }

    @Override
    public String buySomething() {
        return super.buySomething() + ",加1个鸡蛋";
    }

    @Override
    public int payMoney() {
        return super.payMoney() + 1;
    }

    @Override
    public String toString() {
        return buySomething() + ",需要支付" + payMoney() + "支付";
    }
}
