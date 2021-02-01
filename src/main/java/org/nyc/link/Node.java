package org.nyc.link;

/**
 * 链表
 * @param <T>
 */
public class Node<T> {

    private Node next ;
    private T data ;

    public Node getNext() {
        return next;
    }

    public Node() {
    }

    public Node(Node next, T data) {
        this.next = next;
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean hasNext(){
        return this.next != null ;
    }

    public void print(){
        Node temp = this ;
        do {
            System.out.print(temp.getData()+",");
            temp = temp.getNext() ;
        } while (temp != null);
    }

    /**
     * 链表初始化
     * @return
     */
    public static Node<Integer> initLinkedList(boolean isBuildCycle){
        Node result = null ;
        Node temp = result ;
        Node head = null ;
        for (int i = 1; i < 10; i++) {
            if(result == null){
                head = new Node(null, i);
                result = head;
                temp = result ;
            } else {
                temp.setNext(new Node(null,i));
                temp = temp.getNext() ;
            }
            if(i == 9 && isBuildCycle){
                temp.setNext(head);
            }
        }

        return result ;
    }
}
