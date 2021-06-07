package com.datatype;

import org.omg.CORBA.Object;

import java.awt.event.ItemEvent;
import java.util.Iterator;

//下压栈(LIFO)(能够动态调整数组大小的实现)
public class ResizingArrayStack<Item>  implements  Iterable<Item> {
    //stack data
    private  Item[] a = (Item[]) new Object[1];
    //stack size
    private  int N = 0;

    //return stack size
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public void push(Item item){
        //此时如果N等于a.length 则栈满，需要扩容栈
        if(N == a.length) resize(2*N);
        //元素加到栈顶
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N] = null; //避免对象游离
        if(N>0 && N == a.length/4) resize(a.length/2);
        return  item;
    }
    private  void resize(int max){
        //将栈移动到一个大小为max的新数组
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++) temp[i]  = a[i];
        a = temp;
    }
    public Iterator<Item> iterator() {
        return null;
    }
}
