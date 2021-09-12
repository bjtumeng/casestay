package com.dudu.juc.communication.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description:信号量
 * 6辆汽车停3个停车位
 * @author:zhaomeng
 * @date:2021/9/12 10:34 下午
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //设置许可的数量
        Semaphore semaphore =new Semaphore(3);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    //获取许可
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"获得停车位");
                    //设置随机的停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }finally {
                    //释放许可
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"离开停车位");
                }
            },"线程"+i).start();
        }
    }
}
