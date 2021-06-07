package com.algorithm;

import java.util.ArrayList;

public class Test1 {

    public static void main(String[] args) {
        lx(14);
    }

    public static void lx(int number){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k = 0; k < number; k++) {
            if (k % 2 != 0) {
                int count = k;
                for (int l = 1; l < k; l = l + 2) {
                    count = count + 2 * l;
                }
                if (count < number) {
                    list.add(k);
                }
            }
        }
        int sum = 0;
        int n = (list.get(list.size() - 1) + 1) / 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int p = 1; p <= 2 * i - 1; p++) {
                System.out.print("*");
                sum++;
            }
            System.out.print("\n");
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int q = 1; q <= 2 * i - 1; q++) {
                System.out.print("*");
                sum++;
            }
            System.out.print("\n");
        }
        System.out.println("剩余*数:" + (number - sum));
    }
}
