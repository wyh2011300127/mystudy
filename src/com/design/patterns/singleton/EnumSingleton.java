package com.design.patterns.singleton;

/**
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 * <p>
 * 单例的枚举实现在《Effective Java》中有提到，因为其功能完整、使用简洁、无偿地提供了序列化机制、
 * 在面对复杂的序列化或者反射攻击时仍然可以绝对防止多次实例化等优点，单元素的枚举类型被作者认为
 * 是实现Singleton的最佳方法。
 * <p>
 * </p>
 *
 * @author:wangyuheng
 * @date:2019/1/25 16:03
 */
public enum EnumSingleton {
    instance;


    public static void main(String[] args) {

    }

}
