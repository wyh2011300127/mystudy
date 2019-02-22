package com.design.patterns.abstractfactory.demo;

import com.design.patterns.abstractfactory.demo.factory.AbstractFactory;
import com.design.patterns.abstractfactory.demo.factory.impl.ColorFactory;
import com.design.patterns.abstractfactory.demo.factory.impl.ShapeFactory;

/**
 * 创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂
 *
 * @author:wangyuheng
 * @date:2019/1/28 10:20
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if ("color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        if ("square".equalsIgnoreCase(choice)) {
            return new ShapeFactory();
        }
        return null;
    }
}