package org.larry.normal.tree;

/**
 * 二叉树
 */
public class BinarySearchTree {

    Node tree ;

    /**
     *
     * @param data
     */
    public void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree ;
        while (p != null){
            if(data > p.data){
                if(p.right == null){
                    p.right = new Node(data) ;
                    return;
                }
                p = p.right ;
            } else{ // data <= p.data
                if(p.left == null){
                    p.left = new Node(data) ;
                    return;
                }
                p = p.left ;
            }
        }
    }

    /**
     * 删除节点
     * @param data
     */
    public void delete(int data){
        // 无子节点，直接删除
        // 只有一子节点，直接将子节点更新到删除节点的位置
        // 有两个子节点，将右子树中的最小节点更新到删除节点的位置
    }

    class Node{
        int data ;
        Node left ;
        Node right ;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
