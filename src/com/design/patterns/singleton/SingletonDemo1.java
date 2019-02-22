package com.design.patterns.singleton;

/**
 * 饿汉式
 * <p>
 * 类加载的时候就创建了实例
 * 优点：类加载的时候创建一次实例，<b>避免了多线程同步问题</b>，
 * 缺点：即使单例没被用到也会创建，浪费内存
 * 存在问题：可以通过反射技术实例化
 * </p>
 *
 * @author:wangyuheng
 * @date:2019/1/25 10:17
 */
public class SingletonDemo1 {
    /**
     * 定义静态变量，类加载的时候初始化静态变量
     */
    private static SingletonDemo1 singletonDemo1 = new SingletonDemo1();

    /**
     * 私有构造函数
     */
    private SingletonDemo1() {
    }

    /**
     * 获取实例的方法
     *
     * @return
     */
    public static SingletonDemo1 getInstance() {
        return singletonDemo1;
    }
}