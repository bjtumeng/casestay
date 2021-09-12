package com.dudu.juc.ticket.sync;

/**
 * @Description: 3个售票员 总共30张票 synchronized版本
 * @author:zhaomeng
 * @date:2021/9/12 9:26 上午
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //创建多个线程，调用资源类的操作方法
        //一般使用匿名内部类实现Runable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"售票员1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"售票员2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        },"售票员3").start();
    }
}

//1.创建资源类，定义属性和操作方法
class Ticket{
    //库存30张票
    private int number =30;

    //卖票操作
    public synchronized void sale(){
        //如果有票 则获得线程名
        if (number>0){
            number--;
            System.out.println(Thread.currentThread().getName()+"剩下："+number);
        }else{
            System.out.println("票卖完了");
        }
    }
}
