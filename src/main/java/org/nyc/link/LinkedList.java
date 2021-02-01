package org.nyc.link;

/**
 * 链表
 */
public class LinkedList{


    /**
     * 链表反转
     *  头查法：取后一个元素，插入到前一个元素的前面
     * @param list
     */
    public static Node<Integer> reverseLinkedList(Node<Integer> list){
        if(list == null || !list.hasNext() ){
            return list;
        }
        Node p = list ;

        Node result = null ;

        while (p != null){
            // 先把后面的存下来
            Node tmpNode = p.getNext() ;
            // p 做为第一个节点
            p.setNext(result);
            result = p ;
            p = tmpNode ;
        }
        return result ;
    }

    /**
     * 链表反转：
     *  就地交换法
     * @param list
     * @return
     */
    public static Node<Integer> reverseLinkedListSwitchTow(Node<Integer> list){
        if(list == null || !list.hasNext() ){
            return list;
        }
        Node result = null ;

        Node p = list ;

        Node pNext = list.getNext() ;

        result = list ;
        while (pNext != null){

            // 1,3,4,5
            p.setNext(pNext.getNext());
            // 2,1
            pNext.setNext(result);
            // 2,null
            result = pNext ;
            // 3,4,5
            pNext = p.getNext() ;
        }

        return result ;
    }

    public static void main(String[] args) {
        Node<Integer> integerNode = Node.initLinkedList(false);
        integerNode.print();
        // 反转
        Node<Integer> integerNode1 = reverseLinkedListSwitchTow(integerNode);
        System.out.println("\n反转后：");
        integerNode1.print();
    }





}
