package com.collection;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

//散列表
public class HashTabDemo {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("请输入id : ");
        int id = scanner.nextInt();
        System.out.println("请输入名称 :");
        String name = scanner.next();
        Emp emp = new Emp();
        emp.setId(id);
        emp.setName(name);
        EmpHasHTable empHasHTable = new EmpHasHTable(7);
        empHasHTable.add(emp);
        empHasHTable.select();

    }
}
class EmpHasHTable{
    private EmpLinkList[] empLinkLists;
    private int size;
    public EmpHasHTable(int size){
        this.size = size;
        empLinkLists = new EmpLinkList[size];
        //初始化链表
        for(int i = 0; i < size; i++){
            empLinkLists[i] = new EmpLinkList();
        }
    }
    public void add(Emp emp){
        int no = getSum(emp.getId());
        empLinkLists[no].add(emp);
    }
    public void select(){
        for(int i = 0; i < size; i++){
            empLinkLists[i].select(i);
        }
    }

    //取模运算
    public int getSum(int id){
        return id % size;
    }
}

//定义链表中元素类型
class Emp{
    public int id;
    public String name;
    public Emp next;    //下一个元素地址
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 链表
class EmpLinkList{
    private Emp head;   //头指针

    //插入操作
    public void add(Emp emp){
        if(head == null){
            head = emp;
            return;
        }
        Emp chead = head;
        while(chead != null){
            chead = chead.next;
        }
        chead.next = emp;
    }
    //遍历操作
    public void select(int no){
        if(head == null){
            System.out.println("第" + no + "个链表为空");
            return;
        }
        Emp current = head;
        while(current != null){
            System.out.println("员工id为: " + current.id + "员工名称为 : " + current.name);
            current = current.next;
        }
    }
    //删除操作
    public void delete(int id){
        if(head == null){
            System.out.println("此链表为空");
        }
        Emp current = head;
        while(current != null){
            if(current.getId() != id){
                current = current.next;
                break;
            }else {
                if(current.next == null){
                    current = null;
                }else{
                    // last
                }
            }
        }
    }
}

