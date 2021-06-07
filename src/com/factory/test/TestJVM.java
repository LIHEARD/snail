package com.factory.test;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestJVM {

    public static void main(String[] args) {
       List<String> list = new ArrayList<String>();
       String s1 = "0";
       String s2 = "1";
       String s3 = "2";
       String s4 = "3";
       list.add(s1);
       list.add(s2);
       list.add(s3);
       list.add(s4);
       String[] strings = new String[4];
       strings[0] = s1;
       strings[1] = s2;
       strings[2] = s3;
       strings[3] = s4;
       System.out.println("list在内存中的地址为：" + strings);
       System.out.println("list中第一个变量在内存中的地址为：" + strings[0]);

    }
}
