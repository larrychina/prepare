package org.nyc.sort;

/**
 * 快排
 */
public class QuicklySort {

    /**
     * 快速排序
     * @param arry
     */
    public static void sort(int [] arry,int start ,int end){
        if(arry == null){
            return;
        }
        if (start < end){
            int index = move(arry,start,end) ;
            sort(arry,0,index -1);
            sort(arry,index + 1,end);
        }

    }

    public static int move(int [] arry, int start,int end){
        // 找到一个基准值，进行比较
        int tmp = arry[start] ;
        while (start < end && arry[end] > tmp){
            end -- ;
        }
        arry[start] = arry[end] ;

        while (start < end && arry[start] < tmp){
            start ++ ;
        }

        arry[end] = arry[start] ;

        arry[start] = tmp ;

        return start ;
    }

    public static void main(String[] args) {
        int a[] = {7,1,4,3,2} ;
        sort(a,0,a.length - 1);

        print(a);

    }

    public static void print(int arr[]){
        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
