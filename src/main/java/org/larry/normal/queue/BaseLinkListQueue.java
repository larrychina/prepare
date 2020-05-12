package org.larry.normal.queue;

public abstract class BaseLinkListQueue<T> implements YQueue<T>{

    class NodeList<T>{
        public NodeList next ;
        private T data ;

        public NodeList(T data) {
            this.data = data;
        }

        public NodeList getNext() {
            return next;
        }

        public void setNext(NodeList next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
