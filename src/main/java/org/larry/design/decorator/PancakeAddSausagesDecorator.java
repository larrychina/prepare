package org.larry.design.decorator;

public class PancakeAddSausagesDecorator extends PancakeDecorator{

    public PancakeAddSausagesDecorator(PancakeSaleComponent pancakeSaleComponent) {
        super(pancakeSaleComponent);
    }

    @Override
    public void doSomething() {

    }

    @Override
    public String buySomething() {
        return super.buySomething() + "加一个香肠";
    }

    @Override
    public int payMoney() {
        return super.payMoney() + 2;
    }
}
