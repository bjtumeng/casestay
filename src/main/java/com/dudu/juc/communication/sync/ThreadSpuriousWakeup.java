package com.dudu.juc.communication.sync;

/**
 * @Description:线程虚假唤醒问题
 * 开启四个线程，线程1：+1 线程2：-1 线程3：+1 线程4：-1
 * @author:zhaomeng
 * @date:2021/9/12 11:37 上午
 */
public class ThreadSpuriousWakeup {
    public static void main(String[] args) {
        NumSpuriousWakeup num =new NumSpuriousWakeup();
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
class NumSpuriousWakeup{
    private int number =0;
    //增加1
    public synchronized void add(){
        //使用while语句防止虚假唤醒
        while (number != 0){
            try {
                //被唤醒之后处于的位置，可能这会不满足判断条件，然后就number++
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+" :: "+number);
        notifyAll();
    }
    //减少1
    public synchronized void decrease(){
        //使用while语句防止虚假唤醒
        while (number != 1){
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+" :: "+number);
        notifyAll();
    }
}
