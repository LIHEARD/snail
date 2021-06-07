package com.datastructure.tableandstackandqueue;
/*
*
*  练习题3.1
* */
public class TestTable {




    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] L = {1,2,3,4,5,6,7,8,9,67,4,3,2};
        int[] P = {1,3,4,6};
        printLots(L,P);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");
    }

    public  static void printLots(int[] L, int[] P){
        for(int i : P){
            System.out.println(L[i]);
        }
    }
}
