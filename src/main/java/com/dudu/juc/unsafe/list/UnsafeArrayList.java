package com.dudu.juc.unsafe.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description:
 * ArrayList线程不安全
 * @author:zhaomeng
 * @date:2021/9/12 2:50 下午
 */
public class UnsafeArrayList {
    public static void main(String[] args) {
//        List<String> lists =new ArrayList<>();
        //解决方式1  使用Vector类
//        List<String> lists =new Vector<>();
        //解决方式2  使用Collections.synchronizedList
//        List<String> lists = Collections.synchronizedList(new ArrayList<>());
        //解决方式3 使用CopyOnWriteArrayList类
        //支持并发读
        //写时复制一份，写东西，覆盖原来那份
        List<String> lists=new CopyOnWriteArrayList<>();
         //开启10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                //因为add方法没有synchronized关键字
                for (int j = 0; j <30 ; j++) {
                    //向集合中增加元素
                    lists.add(UUID.randomUUID().toString());
                    //获取集合中的元素
                    //报错：java.util.ConcurrentModificationException
                    System.out.println(lists);
                }
            },"线程"+i).start();
        }
    }
}
/**
 *     public boolean add(E e) {
 *       //加锁 说明同时只能有一个修改
 *         final ReentrantLock lock = this.lock;
 *         lock.lock();
 *         try {
 *             Object[] elements = getArray();
 *             int len = elements.length;
 *             Object[] newElements = Arrays.copyOf(elements, len + 1);
 *             newElements[len] = e;
 *             setArray(newElements);
 *             return true;
 *         } finally {
 *             lock.unlock();
 *         }
 *     }
 */
