package com.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyThread implements Callable {
    public Object call() throws Exception {
        System.out.println("开始线程");
        return 1;
    }

    public static void main(String[] args) {
        FutureTask future = new FutureTask(new MyThread());
        Thread thread = new Thread(future);
        thread.start();
    }
}
