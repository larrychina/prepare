package org.larry.design.strage;

public class BusinessA implements FlCodeOperationStrage {
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
