package org.larry.normal.tree;

/**
 * 二叉树的基本操作
 * 插入：
 * 删除：
 * 查找：
 * 计算树的高度：根节点到叶子节点的最长路径（边数）
 * 深度：跟节点到该节点所经历的边的个数
 * 计算树的层级：深度+1
 * 遍历方式：前遍历，中遍历，后遍历
 */
public class BinarySearchTree<T extends Integer> {

    Node<T> tree ;

    public void insertLeef(T data){
        if(tree == null){
            tree = new Node(data);
            return;
        }
        Node<T> node = tree ;
        Node parentNode = tree ;
        while (node != null){
            if(node.getData().compareTo(data)>=0){
                // 左子树
                if(node.left == null){
                    node.left = new Node(data) ;
                    return;
                }
                node = node.left ;
            } else{
                // 右子树
                if(node.right == null){
                    node.right = new Node(data) ;
                    return;
                }
                node = node.right;
            }
        }
    }

    /**
     * 删除节点，三种场景
     * 1，没有子节点，直接删除
     * 2，只有一个子节点，将子节点替换为当前节点
     * 3，有两个子节点，则找到 左子树的最大节点，或者右子树的最小节点
     * @param data
     * @return
     */
    public T delteData(T data){
        Node<T> node = tree ;
        Node parentNode = null ;// 当前节点的上级节点
        while (node != null && node.getData() != data){
            parentNode = node ;
            if(node.getData().compareTo(data) > 0){
                node = node.left ;
            } else {
                node = node.right ;
            }
        }
        if(node == null){
            return null ;
        }
        // 子节点都不为空
        if(node.left != null && node.right !=null){
            Node tmp  =  node.left;
            Node pTmp = null ;
            while (tmp.left == null){
                pTmp = tmp;
                tmp = tmp.left ;
            }
          //  pTmp.left = null ;
            node = tmp ;
            parentNode = pTmp ;
        }
        Node<T> child = null ;
        if(node.left !=null){
            child = node.left ;
        } else if(node.right != null){
            child = node.right ;
        }
        if(parentNode == null ){
            node = child ;
        } else if(parentNode.left == node){
            parentNode.left = child ;
        } else {
            parentNode.right = child ;
        }
        return data ;
    }


    /**
     * 计算树的高度
     * @param node
     * @return
     */
    public int getHeight(Node<T> node){
        if(node == null){
            return 0 ;
        }
        int l = getHeight(node.getLeft()) ;
        int r = getHeight(node.getRight()) ;
        return l > r ? l + 1 : r + 1 ;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertLeef(1);
        tree.insertLeef(2);
        tree.insertLeef(2);
        tree.insertLeef(3);
        tree.insertLeef(2);
        System.out.println(tree);
    }

    class Node<T>{
        private T data ;
        private Node left ;
        private Node right ;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
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
