package org.larry.normal.sort;

/**
 * 利用二分查找实现求平方根
 */
public class BinSearchBySqart {


    /**
     * 计算平方根
     * @param num 目标数字
     * @param e 误差
     * @return
     */
    public static float quart(float num , float e){
        float low = 0f ;
        if( num < 0 || num > 100) {
            return -1 ;
        }
        float high = num ;
        while (low < high){
            float mid = (high + low) / 2 ;
            if(mid*mid < num - e){
                low = mid ;
            } else if(mid*mid > num + e){
                high = mid ;
            } else {
                return mid ;
            }
        }
        return -1 ;
    }

    public static void main(String[] args) {
        System.out.println(quart(100,0.01f));
    }
}
