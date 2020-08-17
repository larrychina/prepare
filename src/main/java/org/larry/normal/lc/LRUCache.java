package org.larry.normal.lc;

/**
 * lru cache
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 */
public class LRUCache {

    Node head ;
    int size ;
    int length ;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public LRUCache(int capacity) {
        head = new Node() ;
        size = capacity ;
    }

    public int get(int key) {
        // 如果存在，取出当前节点放到头部
        Node elementByKey = findElementByKey(key);
        if(elementByKey == null){
            return -1 ;
        }
        return elementByKey.getValue() ;
    }

    public void put(int key, int value) {
        // 查找是否存在此节点
        // 如果存在更新value ，放入头部
        // 如果不存在，直接放入头部
        Node elementByKey = findElementByKey(key);
        if(elementByKey != null){
            elementByKey.next = head.next.next ;
            elementByKey.value = value ;
            head.next = elementByKey ;
        } else{
            if(length >= size ){
                deleteTailNode();
            }
            Node newNode = new Node(key,value);
            newNode.next = head.next ;
            head.next = newNode ;
            length ++ ;
        }

    }

    /**
     * 删除队尾元素
     * @return
     */
    public boolean deleteTailNode(){
        Node tmp = head ;
        while (tmp.next.next != null){
            tmp = tmp.next ;
        }
        tmp.next = null ;
        length -- ;
        return true ;
    }

    public Node findElementByKey(int key){
        Node temp = head.next ;
        Node preNode = head ;
        Node currNode = null ;


        while (temp != null ){
            if(temp.key == key){
                preNode.next = temp.next ;
                currNode = temp ;
                break;
            }
            preNode = preNode.next ;
            temp = temp.next ;
        }
        if(currNode !=null){
            currNode.next = head.next ;
            head.next = currNode ;
            return currNode;
        }
        return null ;
    }


    public class Node{

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        private Node next ;
        private int key ;
        private int value ;
        private int length ;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2) ;
        cache.put(1,1);
        cache.put(2,2);

        System.out.println(cache.get(1));;
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4)) ;
    /*    ["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]*/
    }
}
