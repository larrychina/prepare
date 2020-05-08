package org.larry.normal.linklist;

/**
 * 括号完整匹配
 * 基本思想：利用栈，判断是左括号就入栈，判断又括号就出栈匹配
 */
public class BracketMatch<T> {

    private NodeList<T> nodeList ;

    /**
     * 入栈
     * @param data
     */
    public void push(T data){
        NodeList node = new NodeList(data);
        node.next = nodeList ;
        nodeList = node ;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        if(nodeList == null){
            return null ;
        }
        NodeList tmp = nodeList.next ;
        T data = (T) nodeList.getData();
        nodeList = tmp ;
        return data ;
    }

    class NodeList<T>{
        private NodeList<T> next ;
        private T data ;

        public NodeList(T data) {
            this.data = data;
        }

        public NodeList<T> getNext() {
            return next;
        }

        public void setNext(NodeList<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }


    enum  LeftBracket{
        CB('(',')'),
        SB('[',']'),
        BB('{','}');

        LeftBracket(char left,char right) {
            this.left = left;
            this.right = right;
        }

        private char left ;
        private char right ;

        public char getLeft() {
            return left;
        }

        public char getRight() {
            return right;
        }

        /**
         * 判断是不是左括号
         * @param str
         * @return
         */
        public static boolean isLeft(char str){
            LeftBracket[] values = LeftBracket.values();
            for (LeftBracket value : values) {
                if(value.getLeft() == str){
                    return true ;
                }
            }
            return false ;
        }

        public static boolean isMatchBracket(Character left,Character right){
            LeftBracket[] values = LeftBracket.values();
            for (LeftBracket value : values) {
                if(value.getRight() == right){
                    return value.getLeft() == left ;
                }
            }
            return false ;
        }

    }

    public boolean isBracketMatch(String str){
        if(str == null){
            return false ;
        }
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            boolean left = LeftBracket.isLeft(c);
            if(left){
                this.push((T) c);
            }else{
                T pop = this.pop();
                boolean equals = LeftBracket.isMatchBracket((Character) pop,c);
                if(!equals){
                    this.nodeList = null ;
                    return false;
                }
            }
        }
        if(this.nodeList == null){
            return true ;
        }
        return false;
    }
    public static void main(String[] args) {
        BracketMatch<Character> bm = new BracketMatch<>();
        String str = "[[[[{}{})()))";
        String str1 = "{{}[[][[{()}]]()]}";
        boolean bracketMatch = bm.isBracketMatch(str);
        boolean bracketMatch1 = bm.isBracketMatch(str1);
        System.out.println(bracketMatch);
        System.out.println(bracketMatch1);
    }
}
