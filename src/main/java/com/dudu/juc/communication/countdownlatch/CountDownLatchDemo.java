package com.dudu.juc.communication.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * 6个同学离开教室，班长才开始锁门
 * 主要作用：减少计数
 * @author:zhaomeng
 * @date:2021/9/12 10:03 下午
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch =new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"离开了教室");
                //同学离开教室，计数器就减1
                latch.countDown();
            },"同学"+i).start();
        }
        latch.await();
        //可能是main线程先执行完，其他线程还没执行完，被锁在屋内,所以增加await操作
        System.out.println(Thread.currentThread().getName()+"班长锁门走人");
    }
}
