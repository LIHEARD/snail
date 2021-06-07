package com.concurrent;

public class TestSynchronized {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new TestSynchronized().deadLock();
    }

    public void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized(A){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (A){
                    synchronized (B) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
