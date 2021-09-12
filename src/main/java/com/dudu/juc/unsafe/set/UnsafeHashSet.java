package com.dudu.juc.unsafe.set;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description:线程不安全的HashSet
 * @author:zhaomeng
 * @date:2021/9/12 3:24 下午
 */
public class UnsafeHashSet {
    public static void main(String[] args) {
//        Set<String> sets = new HashSet<>();
        //解决方式1
        Set<String> sets = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                //因为add方法没有synchronized关键字
                for (int j = 0; j <30 ; j++) {
                    //向集合中增加元素
                    sets.add(UUID.randomUUID().toString());
                    //获取集合中的元素
                    //报错：java.util.ConcurrentModificationException
                    System.out.println(sets);
                }
            },"线程"+i).start();
        }
    }
}
