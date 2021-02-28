package org.nyc.sort;

/**
 * 选择排序
 * 每次找到最小的
 */
public class SelectSort {
    /**
     * 选择排序
     * @param arry
     */
    public static void sort(int arry []){
        if(arry == null){
            return ;
        }

        int minIndex ;
        for (int i = 0; i < arry.length - 1; i++) {
            minIndex = i ;
            for (int j = i + 1 ; j < arry.length ; j++) {
               if(arry[minIndex] > arry[j]){
                   minIndex = j ;
               }
            }
            // 进行交换，最小值排在前面
            if(minIndex != i){
                int tmp = arry[i];
                arry[i] = arry[minIndex] ;
                arry[minIndex] = tmp ;
            }
        }
    }


    public static void main(String[] args) {
        int a[] = {7,1,4,3,2} ;
        sort(a);

        print(a);

    }

    public static void print(int arr[]){
        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
