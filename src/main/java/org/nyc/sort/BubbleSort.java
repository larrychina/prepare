package org.nyc.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 排序算法
     * @param arry
     */
    public void sort(int arry []){
        if(arry == null){
            return ;
        }
        // 循环次数
        for (int i = 0; i < arry.length; i++) {

            for (int j = 0; j < arry.length - i - 1; j++) {
                // 当前元素和下一个下标元素进行比较
                if(arry[j] > arry[j+1]){
                    int tmp = arry[j] ;
                    arry[j] = arry[j+1] ;
                    arry[j+1] = tmp ;
                }
            }
        }
    }
}
