package org.larry.normal.sort;

/**
 * 冒泡排序
 * 基本思想：
 * 时间复杂度：
 * 空间复杂度：
 * 是否稳定：
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    public int [] bubleSort(int arr[]){
        if(arr == null || arr.length == 0){
            return arr;
        }

        int tmp  ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i ; j--) {

                if(arr[j] < arr[j-1]){
                    tmp = arr[j-1];
                    arr[j-1] = arr[j] ;
                    arr[j] = tmp ;
                }
            }
        }
        return arr ;
    }


    public void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
    public static void main(String[] args) {

        int arr[] = new int[]{1,5,9,4,6,7,2};
        int arr1[] = new int[]{7,6,5,4,3,2,1};
        BubbleSort bs = new BubbleSort() ;
        bs.print(bs.bubleSort(arr));
        bs.print(bs.bubleSort(arr1));
    }
}
