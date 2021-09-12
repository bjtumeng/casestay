package com.dudu.juc.communication.sync;

/**
 * @Description:现在有两个线程，对变量0，依次增加1和减少1
 * @author:zhaomeng
 * @date:2021/9/12 10:07 上午
 */
public class ThreadNotify {
    public static void main(String[] args) {
        NumNotify num =new NumNotify();
        //开启两个线程
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
    }
}
class NumNotify{
    private int number =0;
    //增加1
    public synchronized void add(){
        //判断->干活->通知
        if (number != 0){
            try {
                //唤醒之后需要增加1
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+" :: "+number);
        //此处必要得唤醒线程2，因为线程处于wait阶段
        notify();
    }
    //减少1
    public synchronized void decrease(){
        //如果先执行decrease，则只会打印 "线程1 :: 1" 因为decrease直接进入wait阶段
        if (number != 1){
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+" :: "+number);
        notify();
    }
}
