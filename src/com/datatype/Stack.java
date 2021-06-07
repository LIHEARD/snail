package com.datatype;

import org.omg.CORBA.Object;

public class Stack<Item> {
    private Item[] items;   //stack entities
    private int length;     //stack length

    public  Stack(int length){
        items = (Item[]) new Object[length];
    }

    public void push(Item item){
        items[length++] = item;
    }
    public int size(){
        return length;
    }
    public Item pop(){
        return items[--length];
    }
    public Item peek(){
        if(length >= 0){
            return items[length-1];
        }else return null;
    }
}
