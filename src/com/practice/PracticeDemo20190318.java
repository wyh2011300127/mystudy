package com.practice;

public class PracticeDemo20190318 {
    public static void main(String[] args) {
        byte i = 127;
        // 0111 1111=
        i += 1;
        System.out.println(showType(i) + " :" + i);
    }

    public static String showType(Object i) {
        return i.getClass().toString();
    }
}