package com.dudu.juc.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @Description: 对1-100的数拆分求和
 * @author:zhaomeng
 * @date:2021/9/15 9:23 下午
 */
public class MyTask extends RecursiveTask<Integer> {
    //拆分逻辑：差值不能小于10
    private static final Integer VALUE =10;
    //拆分开始值
    private int begin;
    //拆分结束值
    private int end;
    //最终返回结果
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        //继续拆分
        if (end-begin>VALUE){
            int middle =(begin+end)/2;
            //拆分左边部分
            MyTask myTask01 = new MyTask(begin, middle);
            //拆分右边部分
            MyTask myTask02 = new MyTask(middle+1, end);
            //调用方法拆分
            myTask01.fork();
            myTask02.fork();
            //合并最后结果
            result=myTask01.join()+myTask02.join();
        }else{
            //计算
            for (int i=begin;i<=end;i++){
                result+=i;
            }
        }
        return result;
    }
}
