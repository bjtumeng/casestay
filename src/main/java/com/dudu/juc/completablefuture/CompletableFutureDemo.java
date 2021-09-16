package com.dudu.juc.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:异步回调demo
 * @author:zhaomeng
 * @date:2021/9/15 9:41 下午
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        //异步调用  没有返回值
      CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(()->{
          System.out.println(Thread.currentThread().getName() + "异步调用没有返回值");
      });
      voidCompletableFuture.get();

      //异步调用  有返回值
        CompletableFuture<Integer> intCompletableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "异步调用有返回值");
            int i=1/0;
            return 1024;
        });
        intCompletableFuture.whenComplete((x,y)->{
            //第一个参数为返回值
            System.out.println("x:"+x);
            //第二个参数为异常信息
            System.out.println("y:"+y);
        }).get();
    }
}
