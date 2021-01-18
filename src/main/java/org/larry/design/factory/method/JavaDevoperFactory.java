package org.larry.design.factory.method;

public class JavaDevoperFactory implements IDevolperFactory {
    @Override
    public IDevolper create() {
        return new JavaDevolper();
    }
}
