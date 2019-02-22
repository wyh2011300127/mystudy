package com.design.patterns.singleton;

/**
 * 静态内部类
 * <p>
 * 静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 * </p>
 *
 * @author:wangyuheng
 * @date:2019/1/25 10:17
 */
public class SingletonDemo4 {

    private SingletonDemo4() {
    }

    private static class SingletonDemo4Holder {
        private static final SingletonDemo4 instance = new SingletonDemo4();
    }

    public static SingletonDemo4 getInstance() {
        return SingletonDemo4Holder.instance;
    }


}