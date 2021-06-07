package com.datatype;

//基于链表形式的栈实现
public class StackNode<Item> {
    private class Node{
        Item item;  // 数据域
        Node next;  // 指针域
    }
    private Node first; //栈顶(最近添加的元素)
    private int N;



    public void push(Item item){
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
