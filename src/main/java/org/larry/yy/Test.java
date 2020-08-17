package org.larry.yy;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
       /* BigDecimal decimal = new BigDecimal("12312.12") ;
        System.out.println(String.valueOf(decimal));*/

       String str = "b" ;
        System.out.println(str.hashCode());
        System.out.println(str.hashCode() >>> 16);
    }
}
