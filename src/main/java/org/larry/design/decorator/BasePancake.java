package org.larry.design.decorator;

/**
 * 被装饰类
 */
public class BasePancake extends PancakeSaleComponent {
    @Override
    public String buySomething() {
        System.out.println("买一个煎饼");
        return "煎饼";
    }

    @Override
    public int payMoney() {
        System.out.println("基础价格"+5+"元");
        return 5 ;
    }
}
