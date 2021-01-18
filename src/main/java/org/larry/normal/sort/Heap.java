package org.larry.normal.sort;

/**
 * 简单的堆操作
 * 堆特性：一颗完全二叉树
 * 数组下标为i的节点 左子树节点下标 2*i  右子树节点下标 2*i+1
 * 父节点下标 i/2
 */
public class Heap {

    // 从下标1开始存储
    private int arr[] ;
    // 当前堆的大小
    private int size ;
    // 堆的总容量
    private int maxCount ;

    public Heap(int capacity) {
        arr = new int[capacity] ;
        maxCount = capacity ;
        size = 0 ;
    }

    /**
     * 大顶堆
     * 新增元素,每次新增元素向下推
     * @param value
     */
    public void insertDown(int value){
        if(size >= maxCount)
            return;
        arr[++size] = value ;
        int i = size ;
        while (i / 2 > 0 && arr[i] > arr[i/2]){
            // 1,交换 swap(arr[i], arr[i/2])
            // 2, 交换后和上一个节点进行比较 i = i / 2
            i = i / 2 ;
        }
    }

    /**
     * 向上推
     * @param value
     */
    public void insertUp(int value){
        if(size >= maxCount)
            return;
        arr[++size] = value ;
        for (int i = size / 2 ; i >= 1 ;i --){
            moveHeap(arr,size,i);
        }
    }

    /**
     * 移除
     */
    public void  removeTopMax(){
        if(size == 0) return ;// 堆中无元素
        arr[1] = arr[size] ;
        size -- ;

    }

    /**
     * 自上向下推
     * @param a 堆数据
     * @param size 堆大小
     * @param i 位置
     */
    public static void moveHeap(int a[],int size,int i){
        while (true){
            int maxPos = i ;
            if(i*2 < size && a[i] < a[i*2])
                maxPos = i * 2 ;
            if((i*2 + 1) < size && a[maxPos] < a[i*2+1])
                maxPos = i * 2 + 1 ;
            if(i == maxPos)
                break;
            // 进行交换 swp(a,i,maxPos)
            i = maxPos ;
        }
    }
}
