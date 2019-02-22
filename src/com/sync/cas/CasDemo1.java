package com.sync.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo1 {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5000; i++) {
                atomicInteger.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new AddThread());
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(atomicInteger);
    }
}