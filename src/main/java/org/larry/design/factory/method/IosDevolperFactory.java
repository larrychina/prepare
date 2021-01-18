package org.larry.design.factory.method;

public class IosDevolperFactory implements IDevolperFactory {
    @Override
    public IDevolper create() {
        return new IosDevolper();
    }
}
