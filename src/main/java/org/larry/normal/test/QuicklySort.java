package org.larry.normal.test;

/**
 * 复习快排
 * 快排的基本思想：找一个基准数，从后往前比，
 * 比基准小的往前，从前往后比，
 * 比基准大的往后移
 */
public class QuicklySort {

    /**
     *
     * @param arr
     * @return
     */
    public int[] sort(int [] arr){
        return null ;
    }


    public int[] sort(int [] arr, int low ,int high){

        while (low < high){
            // 获取 基准数index
            int index = getIndex(arr,low,high) ;
            // 基数往后
            sort(arr,0,index-1) ;
            // 基数往前
            sort(arr,index+1,high) ;
        }
        return null ;
    }

    public int getIndex(int [] arr, int low ,int high){

        int indexValue = arr[low] ;

        while (low < high && indexValue < arr[high]){
            high -- ;
        }
        arr[low] = arr[high] ;

        while (low < high && indexValue > arr[low]) {
            low ++ ;
        }

        arr[high] = arr[low] ;

        arr[low] = indexValue ;

        return low ;

    }

}
