package org.larry.design.template;

public class BussinessAService extends CommonOrderService {

    private boolean special = false ;

    @Override
    public boolean special() {
        return special ;
    }

    @Override
    public void other() {
        System.out.println("A执行特殊逻辑");
    }

    public BussinessAService(boolean special) {
        this.special = special;
    }

    public BussinessAService() {
    }
}
