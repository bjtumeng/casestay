package com.dudu.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * 线程池demo
 * @author:zhaomeng
 * @date:2021/9/14 9:22 下午
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //5个窗口 固定线程个数
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //一个线程个数
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //不固定数量线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        try{
            for (int i = 1; i <=100 ; i++) {
                cachedThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //不关闭线程池 程序不会结束
            cachedThreadPool.shutdown();
        }

    }
}
