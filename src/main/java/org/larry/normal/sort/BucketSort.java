package org.larry.normal.sort;

/**
 * 桶排序
 * 基本思想：先根据相同大小将数据分段，如果遇到数据分布不均则进行扩容
 *           然后每个段采用快速排序
 */
public class BucketSort {


    /**
     * 桶排序
     *  1， 找到最大值最小值，计算出桶个数
     *  2， 设置二维数组，存储数据
     *  3， 如果遇到数据分步不均，则进行桶扩容
     *  4， 对每个桶数据进行快速排序
     * @param arr
     * @param bucketSize
     */
    public void sort(int arr[],int bucketSize){

        if(arr.length < 2 || arr == null){
            return;
        }

        // step1:
        int maxValue = arr[0] , minValue = arr[0] ;
        for (int i = 0; i < arr.length ; i++) {
            if(maxValue < arr[i]){
                maxValue = arr[i] ;
            }
            if(minValue > arr[i]){
                minValue = arr[i] ;
            }
        }
        // 桶的个数
        int bucketCount = ( maxValue - minValue ) / bucketSize + 1 ;

        // 定义一个桶存放数据
        int [][] bucketArr = new int[bucketCount][bucketSize] ;
        // 用于计算当前桶是否满了，是否需要扩容
        int [] indexArr = new int[bucketSize] ;

        for (int i = 0; i < arr.length ; i++) {
            // 定义当前数据属于哪个桶
            int indexArrI = (arr[i] - minValue) / bucketSize ;
            //if(indexArr[indexArrI] == bucketArr[indexArrI][])
        }
    }
}
