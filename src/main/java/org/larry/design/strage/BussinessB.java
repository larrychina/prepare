package org.larry.design.strage;

public class BussinessB implements FlCodeOperationStrage {
    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public boolean lock() {
        return false;
    }

    @Override
    public boolean deduct() {
        return false;
    }

    @Override
    public boolean unLock() {
        return false;
    }
}
