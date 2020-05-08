package org.larry.normal.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断链表中是否有环
 */
public class FindCycleLinkList<T> {

    /**
     * 判断是否有环
     * @param linkList
     * @return
     */
   public boolean judgeHaveCycle(Node<T> linkList){

       if(linkList == null || linkList.next == null){
           return false ;
       }
       Node fast = linkList ;
       Node slow = linkList ;
       while (fast.next != null && fast.next.next != null ){
            fast = fast.next.next ;
            slow = slow.next ;
            if(slow == fast){
                return true ;
            }
       }
       return false ;
   }


    /**
     * 查找中间节点
     * @param linkList
     * @return
     */
   public List<T> findMiddleNode(Node<T> linkList){
       List<T> result = new ArrayList<>() ;
       if(linkList == null){
           return null ;
       }
       if( linkList.next == null){
           result.add(linkList.getData());
           return result ;
       }
       Node<T> fast = linkList ;
       Node<T> slow = linkList ;

       while (fast.next != null && fast.next.next != null){
           fast = fast.next.next ;
           slow = slow.next ;
       }
       if(fast.next == null){
           result.add(slow.getData());
           return result ;
       }
       if(fast.next.next == null){
           result.add(slow.getData());
           result.add((T) slow.next.getData());
           return result ;
       }
       return null;
   }



   public Node<String> buildByString(String [] strs ,boolean settingCycle){
       Node<String> node = null ;
       Node temp = node ;
       for (int i =0 ; i < strs.length ; i++) {
           String str = strs[i];
           if(node == null){
               node = new Node<String>(str);
               node.next = null ;
               temp = node ;
           } else{
               temp.next = new Node<String>(str);
               temp = temp.next ;
           }
           if(i == strs.length - 1 && settingCycle ){
               temp.next = node ;
           }
       }
       return node ;
   }



    public static class Node<T>{
        private T data ;
        private Node next ;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        FindCycleLinkList<String> findCycleLinkList = new FindCycleLinkList<>() ;
       // Node<String> stringNode = (FindCycleLinkList.Node<String>) findCycleLinkList.buildByString(new String[]{"1", "2", "3", "4"}, true);
        Node<String> stringNode = (FindCycleLinkList.Node<String>) findCycleLinkList.buildByString(new String[]{"1"}, false);
        Node<String> stringNode1 = (FindCycleLinkList.Node<String>) findCycleLinkList.buildByString(new String[]{"1", "2", "3", "4"}, false);
        Node<String> stringNode2 = (FindCycleLinkList.Node<String>) findCycleLinkList.buildByString(new String[]{"1", "2", "3", "4","5"}, false);
        Node<String> stringNode3 = (FindCycleLinkList.Node<String>) findCycleLinkList.buildByString(new String[]{"1", "2", "3", "4","5","6"}, false);


        System.out.println(findCycleLinkList.judgeHaveCycle(stringNode));
        System.out.println(findCycleLinkList.findMiddleNode(stringNode1));
        System.out.println(findCycleLinkList.findMiddleNode(stringNode2));
        System.out.println(findCycleLinkList.findMiddleNode(stringNode3));
     //   System.out.println(findCycleLinkList.judgeHaveCycle(stringNode1));
    }
}
