package com.dudu.juc.communication.lock;

/**
 * @Description: 线程定制化通信代码
 * 有3个线程,按照顺序依次执行
 * 分别是线程1执行5次，线程2执行10次，线程3执行15次，整体循环10次
 * @author:zhaomeng
 * @date:2021/9/12 2:14 下午
 */
public class CustomOutput {
    public static void main(String[] args) {
        Resource resource =new Resource();
        new Thread(()->{
            //控制线程1循环10次
            for (int i = 1; i <=10; i++) {
                try {
                    resource.print5(i);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        },"线程1").start();
        new Thread(()->{
            //控制线程2循环10次
            for (int i = 1; i <=10; i++) {
                try {
                    resource.print10(i);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        },"线程2").start();
        new Thread(()->{
            //控制线程3循环10次
            for (int i = 1; i <=10; i++) {
                try {
                    resource.print15(i);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        },"线程3").start();
    }

}

