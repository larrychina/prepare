package org.nyc.sort;

/**
 * 桶排序
 * 分为多个桶，每个桶采用快排
 */
public class BucketSort {

    public static void sort(int arry[], int bucketSize)
    {
        if(arry == null || arry.length < 2){
            return;
        }

        int max = arry[0] ;
        int min = arry[0] ;
        for (int i = 1; i < arry.length; i++) {
            if(max < arry[i]){
                max = arry[i] ;
            }
            if(min > arry[i]){
                min = arry[i] ;
            }
        }

        // 桶的数量
        int bucketCount = ( max - min )/ bucketSize + 1 ;

        int [][]bucketArry = new int[bucketCount][bucketSize];

        // 记录每个桶里的数量
        int [] bucketCountIndex = new int[bucketCount] ;

        // 数据装桶
        for (int i = 0; i < arry.length; i++) {
            int index = (arry[i] - min) / bucketSize;
            // 需要进行扩容
            if(bucketCountIndex[index] == bucketSize){
                dilation(bucketArry,index);
            }
            bucketArry[index][bucketCountIndex[index]++] = arry[i] ;
        }
        int k = 0 ;
        for (int i = 0; i < bucketArry.length; i++) {
             quicklySort(bucketArry[i],0,bucketCountIndex[i]-1);
            for (int j = 0; j < bucketCountIndex[i]; j++) {
                arry[k++] = bucketArry[i][j];
            }
        }
    }


    /**
     * 扩容
     * @param arry
     * @param index
     */
    public static void dilation(int [][] arry, int index){
        int[] ints = arry[index];
        int [] newArry = new int[ints.length * 2] ;
        for (int i = 0; i < ints.length; i++) {
            newArry[i] = ints[i];
        }
        arry[index] = newArry ;
    }


    /**
     * 桶内的元素进行快速排序
     * @param arry
     * @param low
     * @param high
     */
    public static void quicklySort(int [] arry,int low ,int high){

        if(low < high){
            int index =quicklySortIndex(arry,low,high);
            quicklySort(arry,low,index);
            quicklySort(arry,index + 1,high);
        }
    }

    /**
     * 快速排序获取索引
     * @param arry
     */
    public static int quicklySortIndex(int [] arry,int low ,int high){
        // 取一个比较值
        int compareValue = arry[low] ;

        while (low < high && compareValue < arry[high]){
            high -- ;
        }
        arry[low] = arry[high] ;
        while (low < high && compareValue > arry[low]){
            low ++ ;
        }
        arry[high] = arry[low] ;
        arry[low] = compareValue ;
        return low ;
    }

    public static void print(int arr[]){
        for (int i : arr) {
            System.out.print(i+",");
        }
    }


    public static void main(String[] args) {
        int a[] = {7,1,4,3,2} ;
        sort(a,2);

        print(a);

    }
}
