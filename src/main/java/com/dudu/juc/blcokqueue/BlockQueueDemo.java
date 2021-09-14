package com.dudu.juc.blcokqueue;

import java.util.concurrent.*;

/**
 * @Description:
 * 展示阻塞队列常用的类和方法
 * @author:zhaomeng
 * @date:2021/9/14 9:49 上午
 */
public class BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //指定队列大小,数组类型
        BlockingQueue<String> blockingQueue =new ArrayBlockingQueue<>(3);
        //add报异常 java.lang.IllegalStateException: Queue full
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d"));
        //offer 插入成功返回true 失败返回false
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("d"));
        //offer 阻塞指定时间 指定时间没结果则返回失败
        System.out.println(blockingQueue.offer("a", 1,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 1,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 1,TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("d", 1,TimeUnit.SECONDS));
        //put 如果满了线程阻塞
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        blockingQueue.put("d");
        // take 如果为空线程阻塞 返回删除的值
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
        //poll 指定时间
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));

        //poll 删除成功返回具体值 失败返回null
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
        //remove报异常 java.util.NoSuchElementException
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
        //element:返回头部元素
//        System.out.println(blockingQueue.element());
        //peek:返回头部元素
//        System.out.println(blockingQueue.peek());

        //默认值为20亿大小，链表类型
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();






        //延迟队列
//        DelayQueue<> delayQueue = new DelayQueue<>();
    }
}
