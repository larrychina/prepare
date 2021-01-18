package org.larry.leetcode.slidlingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口机制
 * 1，计算指定字符串无重复子串长度
 * 2，计算数组中n个连续数组的最大和
 */
public class SlidingWindow {

    /**
     * 查找指定字符串的无重复子串长度
     * @param str
     * @return
     */
    public static int findLongestSubStr(String str){
        if(null == str || str.length() == 0){
            return 0 ;
        }

        int maxLeng = 0 ; // 定义最大长度
        int rightPoint = -1 ;  // 向右的指针，初始化不指向任何位置-1,

        Set<Character>  sets = new HashSet<>() ;
        // 字符串总长度
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if(i > 0){
                sets.remove(str.charAt(i-1)) ;
            }
            while (rightPoint + 1 < length && !sets.contains(str.charAt(rightPoint+1))){
                sets.add(str.charAt(rightPoint+1));
                rightPoint ++ ;
            }
            maxLeng = Math.max(maxLeng,rightPoint - i + 1 ) ;
        }
        return maxLeng ;
    }

    /**
     * 计算数组中n个连续数得最大值
     * @param arr
     * @return
     */
    public int caculateMaxValue(int arr[],int n){
        if(arr.length == 0  || arr.length < n){
            return 0 ;
        }

        // 最大值
        int maxValue = 0 ;
        for (int i = 0; i < n; i++) {
            maxValue += arr[i] ;
        }
        // 窗口区间和
        int windownValue = maxValue ;
        for (int i = n; i < arr.length; i++) {
            windownValue += arr[i] - arr[i-n] ;
            if(windownValue > maxValue){
                maxValue = windownValue ;
            }
        }
        return maxValue ;
    }


    /**
     * test
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0 ;
        }
        int rPos = 0 ;
        int maxLength = 0 ;
        Set<Character> sets = new HashSet<>() ;
        for (int i = 0; i < s.length(); i++) {
            if(i > 0){
                sets.remove(s.charAt(i-1)) ;
            }
            while (rPos < s.length() && !sets.contains(s.charAt(rPos))){
                sets.add(s.charAt(rPos));
                rPos++ ;
            }
            maxLength = Math.max(maxLength,rPos-i) ;
        }
        return maxLength ;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdefggafasdfasdfasdf"));
    }

}
