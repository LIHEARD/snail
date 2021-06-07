package com.algorithm;

import java.util.Arrays;

/*
*
*   插入排序 : 假设n-1个元素已经排序，取出第n个元素依次与有序数组中元素比较，如果插入n仍然为有序数组，则插入，然后依次进行此步骤
*
* */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {4,3,2,15,6,3};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        int current;
        for(int i = 0; i < arr.length - 1; i++){
            //取出元素记录比较
            current = arr[i+1];
            int index = i;
            //判断下一个元素是否小于前面排序好的数组
            while(index >= 0 && current < arr[index]){
                //说明此时arr[index + 1]的值大于arr[index]的值，所以此时要把大的值赋给
                arr[index + 1] = arr[index];
                index--;
            }
            //因为跳出循环需要index 的值小于0，所以此时需要+1
            arr[index + 1] = current;
        }
        System.out.println(Arrays.toString(arr));
    }
}
