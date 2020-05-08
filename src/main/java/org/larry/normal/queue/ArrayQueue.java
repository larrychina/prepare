package org.larry.normal.queue;

/**
 * 基于数组的队列，有序队列
 */
public class ArrayQueue<T> {

    private int head ;
    private Object elementData[] ;
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
    public void enQueue(T data){
        if(tailIndex < elementData.length){
            elementData[tailIndex++] = data ;
        } else{
            if(tailIndex == head){
                tailIndex = 0 ;
                head = 0 ;
            }
        }
    }

    /**
     * 出队列
     */
    public T deQueue(){
        if(head == tailIndex ){
            return null ;
        }
        return  (T) elementData[head++];
    }
}

