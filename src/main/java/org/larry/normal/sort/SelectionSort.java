package org.larry.normal.sort;

/**
 * 选择排序
 * 基本思想，每次比较一轮找到最小的一个
 */
public class SelectionSort {


    /**
     * 选择排序
     * @param arr
     * @return
     */
    public int[] sort(int arr[]){

        if(arr == null || arr.length == 0){
            return arr ;
        }
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i ;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j ;
                }
            }
            int tmp = arr[i] ;
            arr[i] = arr[minIndex] ;
            arr[minIndex] = tmp ;
        }
        return arr ;
    }

    public void print(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println("");
    }
    public static void main(String[] args) {

        int arr[] = new int[]{1,5,9,4,6,7,2};
        int arr1[] = new int[]{7,6,5,4,3,2,1};
        SelectionSort bs = new SelectionSort() ;
        bs.print(bs.sort(arr));
        bs.print(bs.sort(arr1));
    }
}
