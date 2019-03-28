package com.thread;

/**
 * 线程
 *
 * @author:wangyuheng
 * @date:2019/3/28 9:32
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        System.out.println("main priority:" + Thread.currentThread().getPriority());

        Thread thread1 = new Thread();
        System.out.println("thread1:" + thread1.getPriority());

        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup");
        threadGroup.setMaxPriority(7);
        Thread thread2 = new Thread(threadGroup, "thread2");
        thread2.setPriority(10);
        System.out.println("thread2:" + thread2.getPriority());
    }
}