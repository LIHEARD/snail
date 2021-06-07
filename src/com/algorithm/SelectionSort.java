package com.algorithm;

import java.util.Arrays;

/*
*   选择排序基本思想 : 先假定最前面的数为最大数，然后用数组中其他元素依次比较这个数，如果不为最大，则记录最大值下标，然后交换
*
* */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5,3,12,4,2,7};
        selectSort(arr);
    }

    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            //假定第一个值为最大值,如果其中一段有序，则会浪费资源
            int maxIndex = i;
            //如果前面的值已经确定，则无需再比较
            for(int j = i; j < arr.length; j++){
                if(arr[maxIndex] < arr[j]){
                    maxIndex = j;
                }
            }
            int temp;
            temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
