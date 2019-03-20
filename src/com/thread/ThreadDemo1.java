package com.thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup());
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.test();
        System.out.println("123456");
    }

    public void test() {
        new Thread(new InnerThreadDemo()).start();
    }

    private static Integer i = 1;

    class InnerThreadDemo implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    System.out.println("i=" + (i++));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}