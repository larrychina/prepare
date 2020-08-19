package org.larry.normal.sort;

/**
 * 快速排序
 * 基本思想：每次选择一个基准值，一趟下来把大的，小的从基准值分开
 * 时间复杂O(nlogn)
 */
public class FastSort {


    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i+",");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(high > low){
            int index = getIndex(arr,low,high) ;
            System.out.println(high);
            quickSort(arr,index+1,high);

            quickSort(arr,0,index-1);
        }

    }
    /**
     * 获取当前基准值
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int getIndex(int arr[] , int low ,int high){

        int tmp = arr[low] ;

        // 高位大于基准值，
        while (low < high && tmp < arr[high]){
            high -- ;
        }

        // 出现小于基准值，赋值给当前低位
        arr[low] = arr[high] ;

        // 低位小于基准值
        while (low < high && tmp >= arr[low]){
            low ++ ;
        }

        // 出现大于基准值，赋值给高位
        arr[high] = arr[low] ;

        // 将基准值赋值给arr[low]
        arr[low] = tmp ;

        // 返回当前基准值的位置
        return low ;
    }
}
