package com.dudu.juc.ticket.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 3个售票员 总共30张票 lock版本
 * @author:zhaomeng
 * @date:2021/9/12 9:48 上午
 */
public class LockSaleTicket {
    public static void main(String[] args) {
        LockTicket ticket = new LockTicket();
        //创建多个线程，调用资源类的操作方法
        //一般使用匿名内部类实现Runable接口
        new Thread(()->{
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
        },"售票员1").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"售票员2").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        },"售票员3").start();
    }
}

//1.创建资源类，定义属性和操作方法
class LockTicket{
    //库存30张票
    private int number =30;
    //传入参数为true时，代表是公平锁，非公平锁会导致所有的票都是售票员1卖的
    private final ReentrantLock lock = new  ReentrantLock(true);

    //卖票操作
    public void sale(){
        lock.lock();
        try{
            //如果有票 则获得线程名
            if (number>0){
                number--;
                System.out.println(Thread.currentThread().getName()+"剩下："+number);
            }else{
                System.out.println("票卖完了");
            }
        }finally {
            lock.unlock();
        }
    }
}

