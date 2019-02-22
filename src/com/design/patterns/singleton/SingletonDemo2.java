package com.design.patterns.singleton;

/**
 * 懒汉-（非线程安全）
 * <p>
 * 优点：需要时才去创建
 * 缺点：没有考虑线程安全问题，多个线程并发调用getInstance，可能会创建多个实例
 * </p>
 *
 * @author:wangyuheng
 * @date:2019/1/25 10:17
 */
public class SingletonDemo2 {

    private static SingletonDemo2 instance = null;

    private SingletonDemo2() {
    }

    public static SingletonDemo2 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingletonDemo2();
        }
        return instance;
    }
}