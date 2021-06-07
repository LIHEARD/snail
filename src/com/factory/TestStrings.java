package com.factory;

import java.util.Arrays;
import java.util.Stack;

public class TestStrings {

    public static void main(String[] args) {
        Stack<String> strings = new Stack<String>();
        String[] strings1 = {"1","2","3","4"};
        strings.addAll(Arrays.asList(strings1));
        strings.setSize(3);
        System.out.println(strings);

    }
}
