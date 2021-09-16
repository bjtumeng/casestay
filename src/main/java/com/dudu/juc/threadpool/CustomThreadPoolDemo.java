package com.dudu.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:自定义线程池
 * @author:zhaomeng
 * @date:2021/9/15 9:11 下午
 */
public class CustomThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                //核心线程数
                2,
                //最大线程数
                5,
                //存活时间
                2l,
                TimeUnit.SECONDS,
                //阻塞队列
                new ArrayBlockingQueue<>(3),
                //线程工厂，这里使用默认线程工厂
                Executors.defaultThreadFactory(),
                //设置拒绝策略
                new ThreadPoolExecutor.AbortPolicy()
        );
        //启动10个线程
        for (int i = 1; i <=10 ; i++) {
           threadPool.execute(()->{
               System.out.println(Thread.currentThread().getName());
           });
        }
        threadPool.shutdown();
    }
}
