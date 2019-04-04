package com.thread;

public class ThreadDemo4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("1111111");
                }
            }
        }).start();

    }
}
