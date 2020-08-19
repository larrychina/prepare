package org.larry.normal.stack;

/**
 * 判断是否是回文串
 */
public class ValidatePalindrome {

    public static boolean validPalindrome(String s) {
        int low = 0 ;
        int high = s.length() - 1 ;
        while (low < high){
            char leftC = s.charAt(low) ;
            char rightC = s.charAt(high) ;
            if(leftC == rightC){
                low ++ ;
                high -- ;
            } else{
                return false ;
                // 删除一个字符看是否满足 abcbad
               /* boolean left = true , right = true ;
                for(int i = low + 1,j = high ; i < j; i++ ,j--){
                    char iC = s.charAt(i) ;
                    char jC = s.charAt(j) ;
                    if(iC != jC){
                        left = false ;
                        break;
                    }
                }

                for(int i = low ,j = high -1; i < j; i++ ,j--){
                    char iC = s.charAt(i) ;
                    char jC = s.charAt(j) ;
                    if(iC != jC){
                        right = false ;
                        break;
                    }
                }
                return  right || left ;*/
            }
        }
        return true ;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aabbcfcbbaa"));;
    }

}
