package com.algorithm;

public class TestSynchronzied  implements  Runnable{
    private Object slet;
    private Object my;
    private  String name;

    public TestSynchronzied(Object slet, Object my, String name) {
        this.slet = slet;
        this.my = my;
        this.name = name;
    }

    public Object getSlet() {
        return slet;
    }

    public void setSlet(Object slet) {
        this.slet = slet;
    }

    public Object getMy() {
        return my;
    }

    public void setMy(Object my) {
        this.my = my;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (slet){
                synchronized (my){
                    System.out.print(name);
                    count--;
                    my.notifyAll();
                    }
                try {
                    slet.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        TestSynchronzied t1 = new TestSynchronzied(a,b,"a");
        TestSynchronzied t2 = new TestSynchronzied(b,c, "b");
        TestSynchronzied t3 = new TestSynchronzied(c,a, "c");
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        Thread thread2 = new Thread(t3);
        thread.start();
        Thread.sleep(10);
        thread1.start();
        Thread.sleep(10);
        thread2.start();
        Thread.sleep(10);

    }
}
