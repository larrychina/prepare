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
        int [] indexArr = new int[bucketCount] ;

        // 为每个桶分配数据
        for (int i = 0; i < arr.length ; i++) {
            // 定义当前数据属于哪个桶
            int indexArrI = (arr[i] - minValue) / bucketSize ;
            if(indexArr[indexArrI] == bucketArr[indexArrI].length){
                ensureCapacity(bucketArr,indexArrI);
            }
            bucketArr[indexArrI][indexArr[indexArrI]++] = arr[i] ;
        }

        // 将数组进行排序组装到原数据中
        int k = 0 ;
        for (int i = 0; i < bucketArr.length; i++) {
            if(indexArr[i] == 0){
                continue;
            }
            fastSort(bucketArr[i],0,indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = bucketArr[i][j] ;
            }
        }

    }


    /**
     * 针对某个桶进行数组扩容
     * @param bucketArr
     * @param index
     */
    public void ensureCapacity(int [][] bucketArr,int index){
        int tmp[] = bucketArr[index] ;
        int newArr [] = new int[tmp.length * 2] ;
        for (int i = 0; i < tmp.length; i++) {
            newArr[i] = tmp[i] ;
        }
        bucketArr[index] = newArr ;
    }


    /**
     * 快速排序
     * @param arr
     */
    void fastSort(int arr[],int low ,int high){

        if(low < high){
            int index = partition(arr,low,high) ;
            fastSort(arr,0,index-1) ;
            fastSort(arr,index+1,high);
        }
    }

    /**
     * 获取索引
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] arr, int low, int high) {
         int indexVaule = arr[low] ;

        while (low < high && indexVaule < arr[high]){
            high -- ;
        }
        arr[low] = arr[high] ;

        while (low < high && indexVaule >= arr[low]){
            low ++ ;
        }

        arr[high] = arr[low] ;

        arr[low] = indexVaule ;

        return low ;
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
        BucketSort bs = new BucketSort() ;
        bs.sort(arr,2);
        bs.print(arr);

        //bs.print(bs.sort(arr1));
    }
}
