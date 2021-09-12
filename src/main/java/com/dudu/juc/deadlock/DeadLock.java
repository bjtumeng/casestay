package com.dudu.juc.deadlock;

/**
 * @Description: 产生死锁
 * @author:zhaomeng
 * @date:2021/9/12 5:04 下午
 */
public class DeadLock {
    //共享资源a
    static private Object a =new Object();
    //共享资源b
    static private Object b =new Object();

    public static void main(String[] args)  {
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"进去a");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"进去b");
                }
            }
        },"线程1").start();
        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"进去b");
                synchronized (a){
                    System.out.println(Thread.currentThread().getName()+"进去a");
                }
            }
        },"线程2").start();
    }
}
