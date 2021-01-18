package org.larry.design.factory.abstractfactory;

public class JavaWorkerFactory extends IWorkFactory {
    @Override
    public IDev createDev() {
        return new JavaDev();
    }

    @Override
    public IDebug createDebug() {
        return new JavaDebug();
    }
}
