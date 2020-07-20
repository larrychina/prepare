package org.larry.normal.linklist;

/**
 * 链表反转：
 */
public class LinkList<T> {

    public static class Node<T>{
        private T data ;
        private FindCycleLinkList.Node next ;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public FindCycleLinkList.Node getNext() {
            return next;
        }

        public void setNext(FindCycleLinkList.Node next) {
            this.next = next;
        }

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }
    }

}
