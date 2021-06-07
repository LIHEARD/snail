package com.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//自定义线程池
public class TestThreadPoolExecutor {
    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(20);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,5,50, TimeUnit.MICROSECONDS,blockingQueue);
        //创建七个任务
        Runnable t1 = new TestRunnable();
        Runnable t2 = new TestRunnable();
        Runnable t3 = new TestRunnable();
        Runnable t4 = new TestRunnable();
        Runnable t5 = new TestRunnable();
        Runnable t6 = new TestRunnable();
        Runnable t7 = new TestRunnable();
        poolExecutor.execute(t1);
        poolExecutor.execute(t2);
        poolExecutor.execute(t3);
        poolExecutor.execute(t4);
        poolExecutor.execute(t5);
        poolExecutor.execute(t6);
        poolExecutor.execute(t7);
        poolExecutor.shutdown();
        Thread.currentThread().getState();
    }
}
