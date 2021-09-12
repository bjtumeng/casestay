package com.dudu.juc.communication.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * 集齐7颗龙珠召唤神龙
 * 总结：需要记住CyclicBarrier的构造方法和await()方法
 * @author:zhaomeng
 * @date:2021/9/12 10:19 下午
 */
public class CyclicBarrierDemo {
    public static void main(String[] args)  {
        CyclicBarrier cyclicBarrier =new CyclicBarrier(7,
                //达到目的后做什么事，需要实现Runnable接口
                ()->{
            System.out.println("集齐7颗龙珠召唤神龙");
        });
        for (int i = 1; i <=7 ; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"收集到龙珠");
                    //龙珠没有到7个时，一直等待
                    cyclicBarrier.await();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"龙珠"+i).start();

        }

    }
}
