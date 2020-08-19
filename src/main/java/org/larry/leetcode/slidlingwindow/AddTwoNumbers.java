package org.larry.leetcode.slidlingwindow;

/**
 * 数组两个数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1 , q = l2 ;
        ListNode resultNode = new ListNode(0) ;
        ListNode tempNode = resultNode  ;
        int highValue = 0 ;
        while (p != null || l2 != null){
            int addVaule = highValue + (p==null?0:p.val) + (q == null ? 0 :q.val) ;
            tempNode.next = new ListNode(addVaule % 10) ;
            highValue = addVaule / 10 ;
            if(p!=null){
                p = p.next ;
            }
            if(q!= null){
                q = q.next ;
            }
            tempNode = tempNode.next;
        }
        if(highValue > 0 ){
            tempNode.next = new ListNode(highValue) ;
        }
        return resultNode.next ;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {

    }
}
