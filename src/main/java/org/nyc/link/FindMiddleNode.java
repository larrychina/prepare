package org.nyc.link;

/**
 * 找链表的中间节点
 */
public class FindMiddleNode {

    /**
     * 找到中间节点
     * 快慢指针法
     * @param list
     * @return
     */
    public static Node<Integer> findMiddleNode(Node<Integer> list){
        if(list == null){
            return list ;
        }
        Node fast = list ;
        Node slow = list ;

        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext() ;
            slow = slow.getNext() ;
        }

        return slow ;
    }

    public static void main(String[] args) {
        Node<Integer> integerNode = Node.initLinkedList(false);
        Node<Integer> middleNode = findMiddleNode(integerNode);
        middleNode.print();
    }
}
