package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//线程池执行callable任务
public class TestCallableExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();
        //创建10个任务执行
        for(int i = 0; i < 10; i++){
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TestCallable(i));
            //执行结果存储到list中
            list.add(future);
        }
        //遍历任务集合
        for(Future<String> fs : list){
            //Future如果没有完成，则一直循环等待，直到Future返回完成
            while(!fs.isDone());
            try {
                //打印各个任务执行结果
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}
class TestCallable implements Callable<String> {
    private int id;
    public TestCallable(int id){
        this.id = id;
    }
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ",,id 为" + id);
        return  id + "" ;
    }


}