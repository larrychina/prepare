package org.larry.normal.queue;

/**
 * 基于链表实现的队列
 */
public class CycleLinkListQueue<T> extends BaseLinkListQueue<T> {

    NodeList<T> elementData ;
    private int length ;
    private int size ;
    private boolean hasBuildCycle = false ;
    NodeList<T> head = null ;
    NodeList<T> tail = null ;

    public CycleLinkListQueue(int length) {
        this.length = length;
    }

    public boolean enQueue(T data){

        if(size == length){
            return false ;
        }
        NodeList node = null ;
        if(!hasBuildCycle){
            node =  new NodeList(data);
        } else {
            node = tail.next ;
            node.setData(data);
        }
        if(tail == null){
            tail = node ;
            head = node ;
            elementData = node ;
       } else{
           tail.next = node ;
           tail = tail.next ;
       }
        size ++ ;
        if(size == length && !hasBuildCycle){
            tail.next = elementData ;
            hasBuildCycle = true ;
        }
        return true ;
    }

    public static void main(String[] args) {
        CycleLinkListQueue<String> queue = new CycleLinkListQueue<>(3);
        System.out.println(queue.enQueue("a"));
        System.out.println(queue.enQueue("b"));
        System.out.println(queue.enQueue("c"));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue("d"));
        System.out.println(queue.enQueue("e"));
        System.out.println(queue.enQueue("f"));
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue("g"));
    }

    public T deQueue(){
        if(head == null){
            return null ;
        }
        T data = head.getData();
        head = head.next ;
        size -- ;
        return data ;
    }


}
