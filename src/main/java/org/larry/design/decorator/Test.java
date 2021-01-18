package org.larry.design.decorator;

public class Test {

    public static void main(String[] args) {
        PancakeSaleComponent pancakeSaleComponent = new BasePancake() ;

        // 加个

        PancakeSaleComponent eggPancake = new PancakeAddEggDecorator(pancakeSaleComponent);

        eggPancake = new PancakeAddEggDecorator(eggPancake);
        System.out.println(eggPancake.toString());
    }
}
