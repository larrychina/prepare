package org.larry.normal.queue;

/**
 * 基于链表实现的队列
 */
public class LinkListQueue<T> extends BaseLinkListQueue<T>{

    NodeList<T> elementData ;
    private int length ;
    private int size ;
    NodeList<T> head = null ;
    NodeList<T> tail = null ;

    public boolean enQueue(T data){

        NodeList node = new NodeList(data) ;
        if(tail == null){
            tail = node ;
            head = node ;
       } else{
           tail.next = node ;
           tail = tail.next ;
       }

        return true ;
    }

    public static void main(String[] args) {
        LinkListQueue<String> queue = new LinkListQueue<>();
        System.out.println(queue.enQueue("a"));
        System.out.println(queue.enQueue("b"));
        System.out.println(queue.enQueue("c"));
        System.out.println(queue.enQueue("d"));
    }

    public T deQueue(){
        if(head == null){
            return null ;
        }
        T data = head.getData();
        head = head.next ;
        return data ;
    }
}
