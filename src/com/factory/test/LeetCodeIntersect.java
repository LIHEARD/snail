package com.factory.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
*   给定两个数组，编写一个程序来实现它们的交集
*   EASY
*
*
* */

public class LeetCodeIntersect {

    public static int[] interset(int[] nums1, int[] nums2){
        List list = new ArrayList();
        for(int num : nums1){
            list.add(num);
        }
        List<Integer> list1 = new ArrayList();
        for(int num1 : nums2){
            if(list.contains(num1)){
                list1.add(num1);
            }
        }
        int arr[] = new int[list1.size()];
        int i = 0;
        for(int n : list1){
            arr[i++] = n;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int sum[] = interset(num1,num2);
        System.out.println(Arrays.toString(sum));
        Object s = "1";
    }
}
