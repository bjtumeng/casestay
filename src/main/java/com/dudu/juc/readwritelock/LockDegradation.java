package com.dudu.juc.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * 展示锁降级的过程
 * @author:zhaomeng
 * @date:2021/9/13 9:37 下午
 */
public class LockDegradation {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        //创建读锁
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        //创建写锁
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        //写锁降级过程
        //1.获取写锁
        writeLock.lock();
        System.out.println("获得写锁");
        //2.获取读锁
        readLock.lock();
        System.out.println("获得读锁");
        //3.释放写锁
        writeLock.unlock();
        System.out.println("释放写锁");
        //4.释放读锁
        readLock.unlock();
        System.out.println("释放读锁");


        //读锁不能升级为写锁
        //1.获取读锁
        readLock.lock();
        System.out.println("获得读锁");
        //2.获取写锁
        writeLock.lock();
        System.out.println("获得写锁");

    }


}

