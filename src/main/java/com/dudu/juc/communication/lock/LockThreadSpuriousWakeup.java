package com.dudu.juc.communication.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:线程虚假唤醒问题
 * 开启四个线程，线程1：+1 线程2：-1 线程3：+1 线程4：-1
 * lock使用await和single方法实现线程通信
 * @author:zhaomeng
 * @date:2021/9/12 11:37 上午
 */
public class LockThreadSpuriousWakeup {
    public static void main(String[] args) {
        LockNumSpuriousWakeup num =new LockNumSpuriousWakeup();
        //开启4个线程
        new Thread(()->{
            //增加和减少交替10次
            for (int i = 0; i <10 ; i++) {
                num.add();
            }
        },"线程1").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                num.decrease();
            }
        },"线程2").start();
        new Thread(()->{
            //增加和减少交替10次
            for (int i = 0; i <10 ; i++) {
                num.add();
            }
        },"线程3").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                num.decrease();
            }
        },"线程4").start();
    }
}

class LockNumSpuriousWakeup{
    private int number =0;
    private Lock lock =new ReentrantLock();
    private Condition condition = lock.newCondition();
    //增加1
    public void add(){
        lock.lock();
        try{
            while (number != 0){
                try {
                    condition.await();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            number++;
            System.out.println(Thread.currentThread().getName()+" :: "+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    //减少1
    public synchronized void decrease(){
        lock.lock();
        try{
            while (number != 1){
                try {
                    condition.await();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            number--;
            System.out.println(Thread.currentThread().getName()+" :: "+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
