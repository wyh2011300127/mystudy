package com.thread;

/**
 * 线程
 *
 * @author:wangyuheng
 * @date:2019/3/28 9:40
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread1 running...");
                }
            }
        });
        // t1.setPriority(10);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread2 running...");
                }
            }
        });
        t2.setPriority(10);
        t2.start();


    }
}