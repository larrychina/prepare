package org.larry.normal.queue;

import java.util.ArrayList;

/**
 * 基于数组的队列，有序队列
 */
public class ArrayQueue<T> implements YQueue<T> {

    private int head ;
    transient Object elementData[] ;
    private int tailIndex ;

    public ArrayQueue(int length) {
        elementData = new Object[length];
        this.tailIndex = 0 ;
        this.head = 0 ;
    }

    /**
     * 进入队列
     * @param data
     */
    public boolean enQueue(T data){
        if(tailIndex == elementData.length){
            // 队列已满
            if(head == 0){
                return false ;
            }
            // 不在第一个，移动数组元素，为了减少移动次数
            if(head > 0 ){
                for(int i = head ; i < tailIndex ; i++){
                    elementData[i-head] = elementData[i];
                }
                tailIndex -= head ;
                head = 0 ;
            }
        }
        // 添加元素到队尾，未满直接加入
        elementData[tailIndex++] = data ;
        return true ;
    }

    /**
     * 出队列
     */
    @Override
    public T deQueue(){
        if(head == tailIndex ){
            return null ;
        }
        return  (T) elementData[head++];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.enQueue(5));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(6));
        System.out.println(queue.enQueue(7));
    }

}

