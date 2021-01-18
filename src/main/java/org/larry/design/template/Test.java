package org.larry.design.template;

public class Test {

    public static void main(String[] args) {
        CommonOrderService bussinessAService = new BussinessAService(true);
        bussinessAService.submitOrder();
        CommonOrderService bussinessBService = new BussinessBService();
        bussinessBService.submitOrder();

    }
}
