package com.dudu.juc.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/9/12 5:26 下午
 */

/**
 * FutureTask使用场景
 * 1.老师上课口渴，老师不可能去买水，让同学去买水
 * 结论：不影响主线程，另开线程执行任务，需要的时候get获得
 * 2.4个同学 1个同学1+2+3。。。。+5
 *          2同学10+11+12+。。。。+50
 *          3同学60+61+62
 *          4同学100+200
 * 结论：第2个同学的计算量大，另开线程让第2个同学计算，先汇总1，3，4的结果，等2计算完，统一汇总
 * 3.
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Runnable接口创建线程
        new Thread(new RunnableThread(),"").start();

        //Runnable接口创建线程 报错
//        new Thread(new CallThread(),"").start();
        //Runnable接口有实现类FutureTask
        //FutureTask构造可以传递Callable
        FutureTask<Integer> future =new FutureTask<>(new CallableThread());

        //使用lambda表达式
        FutureTask<Integer> future1=new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+"实现callable接口");
            return 100;
        });
        //创建线程
        new Thread(future1,"callable线程").start();
        while(!future1.isDone()){
            System.out.println("正在计算中");
        }
        Integer value1 = future1.get();
        //结果只会计算一次
        Integer value2 = future1.get();
        System.out.println(Thread.currentThread().getName()+":: "+value1);

    }
}
