package org.nyc.link;

/**
 * 删除倒数第N个节点
 */
public class DeleteNthNode {


    /**
     * 删除链表中倒数第N个节点
     * 两个指针，第一个指针先走N布，然后两个指针同时走，第一个走到最后一个，
     * 第二个指针所指的节点就是要删除的节点
     * @param list
     * @param n
     * @return
     */
    public static Node<Integer> delete(Node<Integer> list , int n ){
        if(list == null){
            return list ;
        }
        Node p = list ;
        Node ptr = list ;
        for (int i = 0; i < n + 1 && p != null; i++) {
            p = p.getNext() ;
        }

        while (p != null){
            p = p.getNext() ;
            ptr = ptr.getNext() ;
        }
        ptr.setNext(ptr.getNext().getNext());
        return list ;
    }


    public static void main(String[] args) {
        Node<Integer> integerNode = Node.initLinkedList(false);
        Node<Integer> delete = delete(integerNode, 1);
        delete.print();
    }
}
