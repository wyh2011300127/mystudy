package com.sync.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas的英文翻译全称是compare and set ，也就是比较替换技术，
 * 它包含三个参数，CAS(V,E,N),其中V（variile）表示欲更新的变量，
 * E(Excepted)表示预期的值，N(New)表示新值,只有当V等于E值的时候，
 * 才会将V的值设为N,如果V值和E值不同，则说明已经有其它线程对该值做了更新，
 * 则当前线程什么都不做，直接返回V值。
 *
 * @author:wangyuheng
 * @date:2019/2/1 10:13
 */
public class CasDemo {
    public static void main(String[] args) {
        //只有当期望值与要改的值一致的时候，cas才会替换原始的值，设置成新值
        AtomicInteger atomicInteger = new AtomicInteger(5);
        boolean b = atomicInteger.compareAndSet(4, 2);
        System.out.println("是否变化：" + b);
        int i = atomicInteger.get();
        System.out.println("变量的值：" + i);
    }
}