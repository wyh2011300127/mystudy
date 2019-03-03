package com.design.patterns.singleton;

public enum EnumSingleton1 {
    instance;

    public static EnumSingleton1 getInstance() {
        return instance;
    }

    private final boolean callService(String xml) {
        return false;
    }

    public static void main(String[] args) {

        EnumSingleton1 instance = EnumSingleton1.getInstance();
        System.out.println(instance.name() + ":" + instance.ordinal());
        boolean b = instance.callService("");
        System.out.println(b);

    }


}
