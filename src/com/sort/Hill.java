package com.sort;

import java.util.*;

public class Hill {

    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        //增量数组h，最小为1
        while(h < N/3) h = 3*h + 1;
        System.out.println(h);
        while(h >= 1){
            //插入排序
            for (int i = h; i < N; i++){
                //将a[i]插入到a[i-h],a[i-2*h],a[i-3*h] ... 之中，也就是在数组中从下标0开始，间隔h，获得a[0+h]的一组数组，比较大小，交换位置
                for (int j = i; j >= h && less(a[j],a[j-h]); j-=h){
                    exch(a,j,j-h);
                }
            }
            //当上面循环结束，此时数组只是排序了各组有序数组，而数组总体并没有排序完成，所以需要使用增量数组中更小的增量来排序
            h = h/3;
        }
        System.out.println(Arrays.toString(a));
    }

    private static void exch(Comparable[] a, int i , int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static boolean less(Comparable v, Comparable a){
       return  v.compareTo(a) < 0;
    }

    public static void main(String[] args) {
        Comparable[] a = {3,21,34,2,34,645};
        Hill.sort(a);
        List list = new ArrayList();
        list.add(2);
        list.add(1);
        list.add(44);
        list.add(3);
        System.out.println(list.get(3));
        Collections.sort(list);
        System.out.println(list.get(3));
    }
}
