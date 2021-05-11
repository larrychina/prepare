package org.larry.normal.sort;

/**
 * 堆排序
 * 构建一个大顶堆
 * 利用删除堆顶元素的原理，
 * 1，每次拿堆堆顶元素和最后一个元素交换
 * 2，交换完重新下推
 *
 * 相比快排：
 * 时间复杂度都是log2（n）
 *  第一点，堆排序数据访问的方式没有快速排序友好。
 *      对于快速排序来说，数据是顺序访问的。而对于堆排序来说，数据是跳着访问的。
 *      比如，堆排序中，最重要的一个操作就是数据的堆化。比如下面这个例子，对堆顶节点进行堆化，
 *      会依次访问数组下标是 1，2，4，8 的元素，而不是像快速排序那样，局部顺序访问，所以，这样对 CPU 缓存是不友好的。
 *
 *  第二点，对于同样的数据，在排序过程中，堆排序算法的数据交换次数要多于快速排序。
 *      我们在讲排序的时候，提过两个概念，有序度和逆序度。对于基于比较的排序算法来说，整个排序过程就是由两个基本的操作组成的，
 *      比较和交换（或移动）。快速排序数据交换的次数不会比逆序度多。
 *
 */
public class HeapSort {

    /**
     * 堆排序
     * @param arr
     * @param size
     */
    public void sort(int arr[],int size){
        int i = size ;
        while (i > 1){
            // step1: 堆顶元素 放到最后一个位置
            // swap(arr,i,i);
            // step2: 指针向前
            --i;
            // step3:堆顶元素下推，将第二大元素放入堆顶
            Heap.moveHeap(arr,i,1);
        }
    }
}