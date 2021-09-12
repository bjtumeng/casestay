package com.dudu.juc.communication.sync;

/**
 * @Description:
 * synchronized锁的8种情况
 * @author:zhaomeng
 * @date:2021/9/12 3:43 下午
 */
/**
 * --------方法加synchronized锁的是对象锁------------
 * 1.标准访问，先打印短信还是邮件
 * 发送短信----
 * 发送邮件----
 * 2.停4秒在短信方法，先打印短信还是邮件
 * 发送短信----
 * 发送邮件----
 * ----------普通方法与锁无关-------------------------
 * 3.新增普通方法，先打印短信还是邮件
 * 获取打招呼消息
 * 发送短信----
 * ---------2部手机用的不是同一个对象锁，所以锁之间不互斥-----
 * 4.现在有两部手机，先打印短信还是邮件
 * 其中发短信方法需要等待4s
 * 发送邮件----
 * 发送短信----
 * -----静态同步方法锁的是类，所以总是先打印短信----------------
 * 5.两个静态同步方法，1部手机，先打印短信还是邮件
 * 发送短信----
 * 发送邮件----
 * 6.两个静态同步方法，2部手机，先打印短信还是邮件
 * 发送短信----
 * 发送邮件----
 * -----类锁和对象锁不互斥---------------
 * 7.1个静态同步方法，1个普通同步方法，1部手机 先打印短信还是邮件
 * 发送邮件----
 * 发送短信----
 * 8.1个静态同步方法，1个普通同步方法，2部手机 先打印短信还是邮件
 * 发送邮件----
 * 发送短信----
 * ------------------------------------
 */
public class SyncRange {
    public static void main(String[] args) throws InterruptedException {
        Phone phone =new Phone();
        Phone phone1 =new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        },"线程1").start();
        //保证肯定时线程1先执行
        Thread.sleep(100);
        new Thread(()->{
//            phone.sendEmail();
//            phone.getHello();
            phone1.sendEmail();
        },"线程2").start();
    }
}
