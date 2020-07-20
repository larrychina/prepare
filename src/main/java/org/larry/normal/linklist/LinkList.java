package org.larry.normal.linklist;

/**
 * 链表反转：
 */
public class LinkList<T> {

    Node linkList  ;


    /**
     * 链表反转
     * @param linkList
     * @return
     */
    public static Node reverseNodeList(Node linkList){
        if(linkList == null){
            return null ;
        }
        Node node = linkList ;
        Node reverse = null ;
        Node tmpNode = null ;
        while (node != null){
            tmpNode = node ;
            node = node.next;
            tmpNode.next = reverse;
            reverse = tmpNode ;
        }
        return reverse ;
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
        Node node = null ;
        Node tmp = node ;
        for (int i = 0; i < 10; i++) {
            if(tmp == null){
                node = new Node(i);
                tmp = node ;
            } else{
                tmp.next = new Node(i) ;
                tmp = tmp.next ;
            }
        }
        Node revese = reverseNodeList(node) ;
        while (revese != null){
            System.out.print(revese.getData()+",");
            revese= revese.next ;

        }
    }


}
