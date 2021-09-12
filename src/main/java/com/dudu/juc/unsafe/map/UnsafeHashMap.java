package com.dudu.juc.unsafe.map;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 线程不安全HashMap
 * @author:zhaomeng
 * @date:2021/9/12 3:33 下午
 */
public class UnsafeHashMap {
    public static void main(String[] args) {
//        HashMap<String,String> hashMap =new HashMap();
        //解决方式
        Map<String,String> hashMap =new ConcurrentHashMap<>();
        //开启10个线程
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                //因为add方法没有synchronized关键字
                for (int j = 0; j <30 ; j++) {
                    //向集合中增加元素
                    hashMap.put(UUID.randomUUID().toString(),"1");
                    //获取集合中的元素
                    //报错：java.util.ConcurrentModificationException
                    System.out.println(hashMap);
                }
            },"线程"+i).start();
        }
    }
}
