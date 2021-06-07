package com.binarytree;

import edu.princeton.cs.algs4.In;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
*   This is binary tree
*   Divided into preordertraversal、MiddleorderTraversal、postordertraversal  use recursion and iteration
*
* */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
// Preorder Iteration Class
class Preorder{

    public static void main(String[] args) {
        TreeNode treeNode = initialization();
        //test recursion
        preorderTraversalR(treeNode);
        System.out.println("Dividing line");
        //test itertion
        preorderTranversalIteration(treeNode);
    }
    //binarytree initialization
    public static TreeNode initialization(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        return treeNode;
    }
    public static List<Integer> preorderTraversalR(TreeNode root){
        //recursion version
        List<Integer> list = new ArrayList<>();
        preorderTranversalRecursal(list,root);
        list.forEach(System.out::println);
        return list;
    }
    public static List<Integer> preorderTranversalRecursal(List<Integer> list, TreeNode root){
        // if root is null , return
        if(root == null){
            return  list;
        }
        list.add(root.val);
        preorderTranversalRecursal(list,root.left);
        preorderTranversalRecursal(list,root.right);
        return list;
    }

    // **********************************************************************
    //iteration
    public static List<Integer>  preorderTranversalIteration(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // when root traverse complete，only get left node，at this time need root store to stack，
        // then again get right node
        while(root != null || !stack.isEmpty()){
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        list.forEach(System.out::println);
        return  list;
    }
}
//Middle order Class
class Middleorder{

    public static void main(String[] args) {
       TreeNode treeNode =  Preorder.initialization();
       middleorderTranversal(treeNode);
       System.out.println("Dividing line");
       middleorderTranversalRecursion(treeNode);

    }
    //iteration verison
    public static List<Integer> middleorderTranversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        middleorderTranversalIteration(list,root);
        list.forEach(System.out::println);
        return list;
    }

    public static List<Integer> middleorderTranversalIteration(List<Integer> list,TreeNode root){
        if(root == null){
            return  list;
        }
        middleorderTranversalIteration(list,root.left);
        list.add(root.val);
        middleorderTranversalIteration(list,root.right);
        return list;
    }

    // **********************************************************************
    //recursion verison
    public static List<Integer> middleorderTranversalRecursion(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || ! stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }

        }
        list.forEach(System.out::println);
        return list;
    }
}

class  Postorder{

    public static void main(String[] args) {
        TreeNode treeNode =  Preorder.initialization();
        postorderTranversal(treeNode);
        System.out.println("");
        postorderTranversalRecursion(treeNode);

    }

    public static List<Integer> postorderTranversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postorderTranversalIteration(list,root);
        list.forEach(System.out::println);
        return list;
    }
    public static List<Integer> postorderTranversalIteration(List<Integer> list,TreeNode root){
        if(root == null){
            return list;
        }
        postorderTranversalIteration(list,root.left);
        postorderTranversalIteration(list, root.right);
        list.add(root.val);
        return list;
    }

    public static  List<Integer> postorderTranversalRecursion(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            if(root.left != null)  stack.push(root.left);
            if(root.right != null)  stack.push(root.right);
        }
        Collections.reverse(list);
        list.forEach(System.out::println);
        return list;
    }
}
