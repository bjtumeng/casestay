package com.dudu.juc.recursion.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * 使用lock方式展示可重入锁
 * @author:zhaomeng
 * @date:2021/9/12 4:38 下午
 */
public class LockRecursion {
    public static void main(String[] args) {
        Lock lock =new ReentrantLock();
        new Thread(()->{
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"外层");
                try{
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"内层");
                }finally {
                    //假如不释放锁对于线程1来说也没关系，但是会影响其他线程获取锁
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        },"线程1").start();

        new Thread(()->{
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                lock.unlock();
            }
        },"线程2").start();
    }
}
