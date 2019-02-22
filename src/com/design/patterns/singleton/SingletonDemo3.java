package com.design.patterns.singleton;

/**
 * 双重校验锁
 * <p>
 * volatile关键字，synchronized关键字
 * 若不使用volatile关键字，JVM有可能出指令重排，带来线程安全问题
 * </p>
 *
 * @author:wangyuheng
 * @date:2019/1/25 10:17
 */
public class SingletonDemo3 {

    private static volatile SingletonDemo3 instance = null;

    private SingletonDemo3() {
    }

    public static SingletonDemo3 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo3.class) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (instance == null) {
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }
}