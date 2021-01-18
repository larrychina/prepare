package org.larry.design.strage;

public class Order {

    public void order(String key){
        // step1 validate
        FlCodeOperationStrage flCodeOperationStrage = FlCodeOperationStrageFactory.getFlCodeOperationStrage(key);
        flCodeOperationStrage.validate() ;

        // step2 order...

    }
}
