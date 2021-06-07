package com.queueandstack;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    // 数据集合
    private List<Integer> list;
    //头指针位置
    private int p_size;

    public MyQueue(){
        list = new ArrayList<>();
        p_size = 0;
    }

    //判空,当头指针长度大于队列长度时，此时代表队列为空
    public boolean isEmpty(){
        return p_size >= list.size();
    }
    public boolean adQueue(int i){
        return list.add(i);
    }
    public boolean delQueue(){
        if(isEmpty()){
            return false;
        }
        int  i  =list.remove(p_size);
        p_size++;
        return  i>0?true:false;
    }
    public int get(int index){
        return list.get(index);
    }

}
