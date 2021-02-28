package org.nyc.sort;

/**
 * 归并排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 */
public class MergeSort {


    /**
     * 归并排序
     * @param arry
     * @param low
     * @param high
     */
    public static void sort(int []arry , int low ,int high){

        if(low < high){

            int index = (low + high) / 2;
            sort(arry,low,index);
            sort(arry,index+1,high);
            merge(arry,low,index,high);
        }
    }

    /**
     * 将 low 到 mindle 和 mindle 到 high进行归并
     * @param arry
     * @param low
     * @param middle
     * @param high
     */
    public static void merge(int [] arry, int low , int middle, int high ){

        // 申请一个临时数组
        int tmp[] = new int[arry.length] ;

        // 定义两个指针，分别指向两段数组
        int i = low  , j = middle + 1 ;

        int index = 0 ;

        while (i <= middle && j <= high ){
            if(arry[i] > arry[j]){
                tmp[index++] = arry[j++];
            }else{
                tmp[index++] = arry[i++];
            }
        }

        while (i <= middle ){
            tmp[index++] = arry[i++];
        }

        while ( j <= high ){
            tmp[index++] = arry[j++];
        }

        index = 0 ;
        // 将临时数组赋值给arry
        while (low <= high){
            arry[low++] = tmp[index++];
        }
    }

    public static void print(int arr[]){
        for (int i : arr) {
            System.out.print(i+",");
        }
    }


    public static void main(String[] args) {
        int a[] = {7,1,4,3,2} ;
        sort(a,0,a.length - 1);

        print(a);

    }
}
