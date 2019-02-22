package com.design.patterns.singleton;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * 单例模式有5种实现方式：饿汉、懒汉、双重校验锁、静态内部类和枚举
 * <p>
 * 实现单例模式三个主要特点：1、构造方法私有化；2、实例化的变量引用私有化；3、获取实例的方法共有。
 * </p>
 *
 * @author wangyuheng
 * @date 2019-1-25
 */
public class SingletonTest {

    public static void main(String[] args) {
        // testDemo1();//饿汉式
        testDemo2();//懒汉式
        // testDemo3();//双重校验锁
        // testDemo4();//静态内部类
        // learnCountDownLatch();
    }

    public static void testDemo1() {
        Set<SingletonDemo1> set = new HashSet<SingletonDemo1>(16);
        int threadCount = 100000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonDemo1 instance = SingletonDemo1.getInstance();
                    set.add(instance);
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (SingletonDemo1 instance : set) {
            System.out.println(instance);
        }
        System.out.println("执行结束");
        try {
            Constructor<SingletonDemo1> constructor = SingletonDemo1.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletonDemo1 newInstance = constructor.newInstance();
            System.out.println(newInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void testDemo2() {
        Set<SingletonDemo2> set = new HashSet<SingletonDemo2>(16);
        int threadCount = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonDemo2 instance = SingletonDemo2.getInstance();
                    set.add(instance);
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (SingletonDemo2 instance : set) {
            System.out.println(instance);
        }
        System.out.println("实例数量：" + set.size());
        System.out.println("执行结束");
    }

    public static void testDemo3() {
        int threadCount = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonDemo3 instance = SingletonDemo3.getInstance();
                    System.out.println(instance.toString());
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //通过反射技术实例化
            Constructor<SingletonDemo3> constructor = SingletonDemo3.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletonDemo3 singletonDemo3 = constructor.newInstance();
            System.out.println(singletonDemo3.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("执行到最后");
    }

    public static void testDemo4() {
        int threadCount = 1000;
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonDemo4.getInstance().toString());
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行到最后");
    }

    public static void learnCountDownLatch() {
        int count = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + Thread.currentThread().getId() + "开始出发");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("10个线程已经执行完毕！开始计算排名");
    }
}