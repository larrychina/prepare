package org.nyc.link;

/**
 * 链表中环的检测
 * 使用快慢指针法
 */
public class CheckCycleWithLinkedList {

    /**
     * 链表中环的检测
     * @param list
     */
    public static boolean checkCycle(Node<Integer> list){
        if(list == null || !list.hasNext()){
            return false ;
        }
        Node fast = list ;
        Node slow = list ;
        while (slow.hasNext() && fast.hasNext()){
            fast = fast.getNext().getNext() ;
            slow = slow.getNext() ;
            if(fast == slow){
                return true ;
            }
        }
        return false ;
    }


    public static void main(String[] args) {
        Node<Integer> integerNode = Node.initLinkedList(false);
        System.out.println("检测结果" + checkCycle(integerNode));
    }
}
