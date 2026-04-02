package com.dudu.debug;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/11/21 10:17 上午
 */
public class MultiThread {
    public static void main(String[] args) {
        multiThread();
    }

    public static void multiThread(){
        new Thread(()->{
            System.out.println("1.床前明月光");
        },"thread1").start();
        new Thread(()->{
            System.out.println("2.疑是地上霜");
        },"thread2").start();
        System.out.println("3.举头望明月");
        System.out.println("4.低头思故乡");
    }
}
