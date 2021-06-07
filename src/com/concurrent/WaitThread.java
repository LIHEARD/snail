package com.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class WaitThread {
    static boolean flag = true;
    static Object lock = new Object();

    static class Wait implements  Runnable{

        public void run() {
            //加锁
            synchronized (lock){
                //条件不满足时，继续wait
                while (flag){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
