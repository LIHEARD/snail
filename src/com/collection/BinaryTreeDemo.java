package com.collection;

public class  BinaryTreeDemo{

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryNode root = new BinaryNode(1,"宋江");
        BinaryNode node = new BinaryNode(2,"吴用");
        BinaryNode node2 = new BinaryNode(3,"卢俊义");
        BinaryNode node3 = new BinaryNode(4,"林冲");
        BinaryNode node4 = new BinaryNode(5,"晁盖");
        root.setLeft(node);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);
        binaryTree.setRoot(root);
        //前序遍历
        binaryTree.beforeOrder();
        //中序遍历
        binaryTree.infixOrder();
        //后序遍历
        binaryTree.afterOrder();
        System.out.println("=============================");
        BinaryNode binaryNode = binaryTree.beforeOrderSeach(4);
        System.out.println(binaryNode);

    }

}

//二叉树
class BinaryTree {
    private BinaryNode root; //头节点
    public void setRoot(BinaryNode root){
        this.root = root;
    }
    //二叉树调用节点的方法
    public void beforeOrder(){
        if (this.root != null) {
            this.root.beforeOrder();
        }else {
            System.out.println("头节点为空");
        }
    }
    public void infixOrder(){
        if (this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("头节点为空");
        }
    }
    public void afterOrder(){
        if (this.root != null) {
            this.root.afterOrder();
        }else {
            System.out.println("头节点为空");
        }
    }
    public BinaryNode beforeOrderSeach(int no){
        BinaryNode node = null;
        if(root != null && root.getId() == no){
            return  root;
        } else {
            node = this.root.beforeOrderSeach(no);
        }
        return node;

    }
}


//节点
class BinaryNode{
    private int id;
    private String name;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(int id, String name){
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    //删除
    public void remove(int no){

    }

    //前序遍历
    public void beforeOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.beforeOrder();
        }
        if(this.right != null){
            this.right.beforeOrder();
        }
    }
    //前序遍历查找
    public BinaryNode beforeOrderSeach(int no){
        if(this.getId() == no){
            return this;
        }
        //如果找到则返回，如果没有找到则查找右子树
        BinaryNode findNode = null;
        //查找左子树
        if(this.left != null){
           findNode =  this.left.beforeOrderSeach(no);
        }
        //如果左子树找到则返回，如果没有找到则找右子树
        if(findNode != null){
            return findNode;
        }
        if(this.right != null){
           findNode =  this.right.beforeOrderSeach(no);
        }
        if(findNode != null){
            return findNode;
        }
        return findNode;
    }

    //中序遍历
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void afterOrder(){
        if(this.left != null){
            this.left.afterOrder();
        }
        if(this.right != null){
            this.right.afterOrder();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
