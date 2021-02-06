package org.nyc.link;

/**
 * 两个有序链表进行合并
 */
public class LinkedListCombine {

    /**
     * 两个有序链表的合并
     * @return
     */
    public static Node<Integer> combine(Node<Integer> aList , Node<Integer> bList){
        if(aList == null){
            return bList ;
        }
        if(bList == null){
            return aList;
        }

        Node<Integer> a = aList ;
        Node<Integer> b = bList ;

        Node<Integer> result = null;
        Node<Integer> p = result ;
        while (a != null & b != null){
            Node temp = null ;
            if(a.getData().compareTo(b.getData()) < 1){
                temp = a ;
                a = a.getNext() ;
            } else {
                temp = b ;
                b = b.getNext() ;
            }
            if(result == null ){
                result = temp ;
                p = result ;
            } else {
                p.setNext(temp);
                p = p.getNext() ;
            }
        }
        if(a != null){
            p.setNext(a);
        }
        if(b != null){
            p.setNext(b);
        }
        return result ;
    }

    public static void main(String[] args) {
        Node<Integer> aIntegerNode = Node.initLinkedList(false);
        Node<Integer> bIntegerNode = Node.initLinkedList(false);
        Node<Integer> combine = combine(aIntegerNode, bIntegerNode);
        combine.print();


    }
}
