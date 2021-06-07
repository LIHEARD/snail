package com.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池执行Runnable
public class TestExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i<10; i++){
            executorService.execute(new TestRunnable());
        }
        executorService.shutdown();
    }
}

class  TestRunnable implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
