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

    static int s  ;
    public static int mySqrt(int x) {
        s=x;
        if(x==0) return 0;
        return ((int)(sqrts(x)));
    }

    public static double sqrts(double x){
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }


    /**
     * 求整数的平方跟
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
       // System.out.println(quart(100,0.01f));
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(1));
        System.out.println(46340 * 46340);
        System.out.println(46339 * 46339);
        System.out.println(Math.sqrt(2147395599));
    }
}
