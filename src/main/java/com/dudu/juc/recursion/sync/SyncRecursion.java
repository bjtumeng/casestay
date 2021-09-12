package com.dudu.juc.recursion.sync;

/**
 * @Description:
 * 使用synchronized展示可重入锁
 * @author:zhaomeng
 * @date:2021/9/12 4:28 下午
 */
public class SyncRecursion {
    public static void main(String[] args) {
        Object object =new Object();
        new Thread(() ->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"外层");
                //假如不是可重入锁，object是被锁定的，就进入不了方法内部
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"中层");
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName()+"内层");
                    }
                }
            }
        },"可重入线程").start();
    }
}
