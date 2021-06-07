package com.java8;

import com.google.api.client.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("数据四");
        list.add("数据一");
        list.add("数据二");
        list.add("数据三");
        list.add("数据五");
        list.add("数据六");
        list.forEach(System.out::println);
        list.stream().map(string -> string == "数据一" );

    }
}
