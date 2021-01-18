package org.larry.design.factory.method;

public class Test {

    public static void main(String[] args) {
        IDevolperFactory factory = new JavaDevoperFactory();
        IDevolper iDevolper = factory.create();
        iDevolper.dev();
    }
}
