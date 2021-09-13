package com.dudu.juc.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 共享资源 模拟缓存
 * @author:zhaomeng
 * @date:2021/9/13 8:44 下午
 */
public class Cache {
   private volatile Map<String,Object> objects =new HashMap<>();

   //增加读写锁
    private ReadWriteLock readWriteLock =new ReentrantReadWriteLock();

   //放数据操作
    public void setObjects(String string,Object object)  {
        //添加写锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+":放数据");
            //模拟放数据耗时操作
            TimeUnit.MICROSECONDS.sleep(300);
            objects.put(string,object);
            System.out.println(Thread.currentThread().getName()+"放完数据");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    //取数据操作
    public Object getObjects(String string) {
        readWriteLock.readLock().lock();
        Object result =null;
        try {
            System.out.println(Thread.currentThread().getName()+"取数据");
            //模拟取数据耗时操作
            TimeUnit.MICROSECONDS.sleep(300);
            result = objects.get(string);
            System.out.println(Thread.currentThread().getName()+"取完数据"+"--"+result);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
        return result;
    }
}
