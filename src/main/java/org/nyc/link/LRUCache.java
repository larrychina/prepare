package org.nyc.link;

/**
 * 基于链表实现lru
 * 1,缓存中存在，找到该节点，删除该节点，并放入头节点位置
 * 2，缓存中不存在，如果缓存已满，删除尾节点，插入头节点
 * 3，缓存中不存在，如果缓存未满，直接插入头节点
 */
public class LRUCache<K,V> {


    Node<String,Integer> node ;

    private final static int CACHE_SIZE = 5 ;

    private int size ;
    private int count ;

    static class Node<T,N>{

        private Node next ;
        private T key ;
        private N value ;


        public Node() {
        }

        public Node(T key, N value) {
            this.key = key;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public N getValue() {
            return value;
        }

        public void setValue(N value) {
            this.value = value;
        }

    }

    /**
     * 写缓存
     * @param key
     * @param value
     */
    public void set(String key ,Integer value ){
        if(node == null){
            node = new Node<>();
            node.setKey(key);
            node.setValue(value);
            this.count = 1 ;
        } else {
            // step1 查询是否在缓存
            // step2 判断缓存是否已满
            findInit(key);

            // 写入缓存
            Node newNode = new Node(key,value);
            if(node == null){
                node = newNode ;
            } else{
                newNode.next = node ;
                node = newNode ;
            }
            this.count++ ;
        }
    }

    /**
     * 查询是否在缓存中
     * @param key
     * @return
     */
    public boolean findInit(String key){
        if(node == null){
            return false ;
        }
        Node p = node;
        Node pNext = null ;
        while (p != null){
            if(key.equals(p.getKey())){
                if(pNext == null){
                    node = p.next ;
                } else {
                    pNext.setNext(p.getNext());
                }
                this.count-- ;
                return true;
            }

            if(this.count == this.size && p.next == null){
                // 最后一个节点
                if(pNext == null){
                    node = null ;
                } else {
                    pNext.next = null ;
                }
            }
            p = p.next ;
            if(pNext == null){
                pNext = node ;
            } else{
                pNext = pNext.next ;
            }
        }

        return false ;
    }

    /**
     * 读缓存
     * @param key
     * @return
     */
    public Integer get(String key){
        if(node == null){
            return null ;
        }
        Node<String,Integer> p = node ;
        while (p != null){
            if(key.equals(p.getKey())){
                return p.getValue();
            }
            p = p.next ;
        }
        return null ;
    }

    public void printCache(){
        if(node == null){
            return ;
        }
        Node<String,Integer> p = node ;
        while (p != null){
            System.out.print(p.getKey()+":"+p.getValue()+",");
            p = p.next ;
        }
        System.out.println("\n");
    }

    public LRUCache(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(CACHE_SIZE) ;
        cache.set("zhangsan",18);
        cache.printCache();
        cache.set("zhangsan",18);
        cache.printCache();
        cache.set("lisi",19);
        cache.set("wanger",20);
        cache.set("zhaosi",21);
        cache.set("liuwu",30);
        cache.set("zhouliu",19);
        cache.printCache();
        cache.set("wangxiaoer",50);

        cache.printCache();
    }
}
