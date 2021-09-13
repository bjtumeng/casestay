package com.dudu.juc.readwritelock;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/9/13 8:44 下午
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Cache cache =new Cache();
        for (int i=1;i<=5;i++){
            final int num = i;
            new Thread(()->{
                cache.setObjects(num+"",num+"");
            },"放数据线程"+i).start();
        }
        for (int i=1;i<=5;i++){
            final int num = i;
            new Thread(()->{
              cache.getObjects(num+"");
            },"取数据线程"+i).start();
        }
    }
}
