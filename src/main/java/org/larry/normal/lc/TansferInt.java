package org.larry.normal.lc;


import java.util.*;

/**
 * 整数转罗马数字
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 */
public class TansferInt {

    private static Map<Integer,String> map = new LinkedHashMap<>() ;

    // private long a ;

    static {
        map.put(1,"I") ;
        map.put(4,"IV");
        map.put(5,"V") ;
        map.put(9,"IX") ;
        map.put(10,"X") ;
        map.put(40,"XL") ;
        map.put(50,"L") ;
        map.put(90,"XC") ;
        map.put(100,"C") ;
        map.put(400,"CD") ;
        map.put(500,"D") ;
        map.put(900,"CM");
        map.put(1000,"M") ;
    }


    public String intToRoman(int num) {
        return getRoman(num).toString();
    }

    public String getRoman(int num) {
        Set<Map.Entry<Integer,String>> entries = map.entrySet();
        String str = "" ;
        Map.Entry<Integer,String> ent  = null ;
        for (Map.Entry<Integer,String> entry : entries) {
            if((num + 1) == entry.getKey()){
                return map.get(1).concat(entry.getValue()) ;
            }
            if((num + 10) == entry.getKey()){
                return map.get(10).concat(entry.getValue()) ;
            }
            if((num + 100) == entry.getKey()){
                return map.get(100).concat(entry.getValue()) ;
            }

            if((num % entry.getKey() ) == num){
                break;
            }
            ent = entry ;
        }
        String roman = ent.getValue();
        num -= ent.getKey() ;
        if(num > 0 ){
            roman =  roman.concat(getRoman(num));
        }
        return roman ;
    }

    public static void main(String[] args) {
        TansferInt tansferInt = new TansferInt() ;

        /*System.out.println(tansferInt.getRoman(1));
        System.out.println(tansferInt.getRoman(2));
        System.out.println(tansferInt.getRoman(3));*/
       /* System.out.println(tansferInt.getRoman(4));
        System.out.println(tansferInt.getRoman(5));
        System.out.println(tansferInt.getRoman(6));
        System.out.println(tansferInt.getRoman(8));
        System.out.println(tansferInt.getRoman(9));
        System.out.println(tansferInt.getRoman(90));
        System.out.println(tansferInt.getRoman(51));
        System.out.println(tansferInt.getRoman(324));
        System.out.println(tansferInt.getRoman(501));*/
//        System.out.println(tansferInt.getRoman(94));

        Integer a = new Integer(13333455) ;

        StringBuffer x = new StringBuffer();

      //  System.out.println(ClassLayout.parseInstance(tansferInt).toPrintable() );;

        x.append(a);
        System.out.println(x.toString());
        System.out.println(x.reverse());
    }

}
