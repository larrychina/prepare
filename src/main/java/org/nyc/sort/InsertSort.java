package org.nyc.sort;

/**
 * 插入排序
 * 将未排序的数据插入到已排序中，始终保持已排序的为有序状态
 */
public class InsertSort {

    /**
     * 插入排序
     * @param arry
     */
    public static void sort(int [] arry){
        if(arry == null){
            return;
        }
        for (int i = 1 ; i < arry.length  ; i ++){

            int tmp = arry[i];
            int posIndex = i ;
            for (int j = i - 1; j >= 0; j--) {
                if(tmp < arry[j]){
                    arry[posIndex] = arry[j] ;
                    posIndex -- ;
                } else {
                    break;
                }
            }
            arry[posIndex] = tmp ;
        }

    }

    public static void print(int arr[]){
        for (int i : arr) {
            System.out.print(i+",");
        }
    }


    public static void main(String[] args) {
        int a[] = {7,1,4,3,2} ;
        sort(a);

        print(a);

    }
}
