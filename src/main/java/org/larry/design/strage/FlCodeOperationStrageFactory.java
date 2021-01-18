package org.larry.design.strage;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂
 *
 */
public class FlCodeOperationStrageFactory {

    private static Map<String,FlCodeOperationStrage> OPERATION_STRAGE = new HashMap<>() ;

    static {
        /**
         *  spring 中可以单独写个方法
         */
        OPERATION_STRAGE.put(OperationKey.FL_AMOUNT,null);
        OPERATION_STRAGE.put(OperationKey.FL_INTEGRAL,null);
        OPERATION_STRAGE.put(OperationKey.FL_TIMES,null);
    }

    /**
     * 获取策略
     * @param operationKey
     * @return
     */
    public static FlCodeOperationStrage getFlCodeOperationStrage(String operationKey){
        FlCodeOperationStrage flCodeOperationStrage = OPERATION_STRAGE.get(operationKey) ;
        if(flCodeOperationStrage == null){
            // todo EmptyStrategy or DefaultStrategy
        }
        return flCodeOperationStrage ;
    }

    private interface OperationKey{
        String FL_AMOUNT = "1" ;
        String FL_TIMES = "2" ;
        String FL_INTEGRAL = "3" ;
    }


}
