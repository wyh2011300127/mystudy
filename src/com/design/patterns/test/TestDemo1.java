package com.design.patterns.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>(16);
        int i = 0;
        int j = i++;
        System.out.println("j:" + j + ",i:" + i);
        int t = 1, a = 0;
        // * i++ 先运算在赋值,例如 a=i++,先运算a=i,后运算i=i+1,所以结果是a==1
        // * ++i 先赋值在运算,例如 a=++i,先运算i=i+1,后运算a=i,所以结果是a==2
        if (t++ > 1) {
            System.out.println("t++ > 1");
        }
        System.out.println("t:" + t);
        Map<String, String> map1 = new ConcurrentHashMap<String, String>(16);
        Lock lock = new ReentrantLock();
    }
}