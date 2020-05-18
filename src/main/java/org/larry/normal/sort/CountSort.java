package org.larry.normal.sort;

/**
 * 基数排序
 * 基本思想:按数据区间分成多个桶
 * 时间复杂度 O(n)
 * 适合非负数的排序场景，大数据量切有重复的场景，高考成绩排序
 */
public class CountSort {

    /**
     * 计数排序
     * @param arr
     * @param n
     */
    public void sort(int [] arr , int n){
        if(n <=1 ){
            return;
        }

        int max = arr[0] ;
        for (int i = 1; i < n; i++) {
            if(max < arr[i]){
                max = arr[i] ;
            }
        }

        // 按每个数据值分一个桶
        int [] c = new int [max + 1] ;

        // 计算每个元素的个数
        for (int i = 0; i < n; i++) {
            c[arr[i]]++ ;
        }

        // 累加，
        for (int i = 1; i <= max; i++) {
            c[i] = c[i] + c[i-1] ;
        }

        // 创建临时数组用于排序之后的结果
        int[] r = new int[n] ;

        for (int i = n-1; i >= 0 ; --i) {
            int index =  c[arr[i]]-1 ;
            r[index] = arr[i] ;
            c[arr[i]] -- ;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = r[i] ;
        }
    }
}
