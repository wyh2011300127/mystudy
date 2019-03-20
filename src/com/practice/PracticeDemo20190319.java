package com.practice;

public class PracticeDemo20190319 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                dao();
            }
        });
        t.run();
        System.out.print("小");
    }

    private static void dao() {
        System.out.print("刀");
    }
}