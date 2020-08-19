package org.larry.leetcode.palindrome;

/**
 * 判断一个整数是否是回文子串数
 * 10 false
 * -101 false
 * 101 true
 * 难度系数：简单
 */
public class PalindromeInteger {

    /**
     * 判断输入是否是回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 1){
            return false;
        }

        int reverseX = 0 ;

        while (reverseX < x){
            reverseX = reverseX * 10 + x % 10 ;
            x = x / 10 ;
        }
        return  x == reverseX || x == reverseX / 10 ;
    }

}
