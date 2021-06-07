package com.theinterview;

import java.util.Arrays;

public class Test1 {

    String str = new String("a");
    char[] chars = {'s','o','a'};


    public static void main(String[] args) {
        String s = new String("ss");
        s = "a";
        System.out.println(s);
        Test1 test1 = new Test1();
        test1.change(test1.str,test1.chars);
        System.out.println(test1.str + "and" + Arrays.toString(test1.chars));
    }
    public void change(String str, char[] chars){
        str = "b";
        chars[1] = 's';
    }
}
