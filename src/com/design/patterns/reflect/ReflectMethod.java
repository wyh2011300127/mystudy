package com.design.patterns.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Java反射技术学习
 *
 * @author:wangyuheng
 * @date:2019/3/28 15:32
 */
public class ReflectMethod {
    public static void main(String[] args) {
        // System.out.println(new ReflectMethod().test1());
        System.out.println(new ReflectMethod().test2());
    }

    /**
     * 调用有参数方法
     *
     * @return
     */
    public String test1() {
        try {
            Method printMethod = this.getClass().getMethod("print", String.class);
            try {
                String print1 = (String) printMethod.invoke(this, "print");
                return print1;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 反射调用不同参数类型的方法
     *
     * @return
     */
    public String test2() {
        try {
            Method printMethod = this.getClass().getMethod("print", String.class, int.class);
            try {
                String type = (String) printMethod.invoke(this, "string", 1);
                return type;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 无参数方法
     */
    public void print() {
        System.out.println("print method no parameter ");
    }

    /**
     * 有参数方法
     *
     * @param param
     * @return
     */
    public String print(String param) {
        return param + "print method String parameter";
    }

    /**
     * 有多个参数参数方法
     *
     * @param param
     * @param count
     * @return
     */
    public String print(String param, int count) {
        return "String:" + param + ",int:" + count;
    }

}