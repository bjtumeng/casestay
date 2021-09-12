package com.dudu.juc.communication.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/9/12 2:34 下午
 */
//1.创建资源类
class Resource{
    private int flag =1; //1:线程1  2：线程2 3：线程3
    private Lock lock = new ReentrantLock();
    Condition condition1 =lock.newCondition();
    Condition condition2 =lock.newCondition();
    Condition condition3 =lock.newCondition();

    //打印5次 传入打印轮次
    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try{
            //1.判断
            while(flag != 1){
                condition1.await();
            }
            //2.干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" 轮次::"+loop);
            }
            flag=2;
            //3.condition2去唤醒
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }
    //打印10次 传入打印轮次
    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try{
            while (flag != 2){
                condition2.await();
            }
            //2.干活
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" 轮次::"+loop);
            }
            flag=3;
            //3.唤醒
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }
    //打印15次 传入打印轮次
    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try{
            //1.判断
            while (flag != 3){
                condition3.await();
            }
            //2.干活
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" 轮次::"+loop);
            }
            flag=1;
            //3.唤醒
            condition1.signal();
        }finally {
            lock.unlock();
        }
    }
}
