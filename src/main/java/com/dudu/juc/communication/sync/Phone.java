package com.dudu.juc.communication.sync;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/9/12 3:43 下午
 */
public class Phone {
    public static synchronized void sendSMS() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发送短信----");
    }
    public synchronized void sendEmail(){
        System.out.println("发送邮件----");
    }
    public void getHello(){
        System.out.println("获取打招呼消息");
    }
}
