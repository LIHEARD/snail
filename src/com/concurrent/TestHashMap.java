package com.concurrent;

import java.util.HashMap;
import java.util.UUID;

//测试hashmap多线程导致死循环问题
public class TestHashMap {

    public static void main(String[] args) {

        final HashMap<String,String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++){
                    new Thread(new Runnable() {
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    },"ftf" + i).start();
                }
            }
        },"ftf");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
