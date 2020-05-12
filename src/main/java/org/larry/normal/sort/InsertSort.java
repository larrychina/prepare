package org.larry.normal.sort;

/**
 * 插入排序
 *  基本思想是：将比较的值插入到一个有序的集合中，每次比较完一个，前面默认都是有序的
 *  时间复杂度O(n方)
 */
public class InsertSort {

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public int [] sort(int arr[]){
        if(arr == null || arr.length == 0){
            return arr ;
        }

        // 每次和前面的集合进行比较
        for (int i = 1; i < arr.length; i++) {
            int tmp  ;
            if(arr[i] > arr[i - 1]){
                continue;
            }
            tmp = arr[i];
            for (int j = i; j > 0 ; j--) {
                if(arr[j-1] > tmp){
                    arr[j] = arr[j-1] ;
                } else{
                    arr[j] = tmp;
                    break;
                }
            }
        }
        return null ;
    }
}
