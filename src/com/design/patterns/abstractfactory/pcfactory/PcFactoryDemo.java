package com.design.patterns.abstractfactory.pcfactory;

import com.design.patterns.abstractfactory.pcfactory.factory.AbstractFactory;
import com.design.patterns.abstractfactory.pcfactory.factory.impl.DellFactory;
import com.design.patterns.abstractfactory.pcfactory.factory.impl.LenovoFactory;

/**
 * 测试类
 *
 * @author:wangyuheng
 * @date:2019/1/28 15:26
 */
public class PcFactoryDemo {
    public static void main(String[] args) {
        try {
            //联想工厂
            AbstractFactory lenovoFactory = new LenovoFactory();
            System.out.println(lenovoFactory.createMouse());
            System.out.println(lenovoFactory.createKeyBoard());
            //戴尔工厂
            AbstractFactory dellFactory = new DellFactory();
            System.out.println(dellFactory.createMouse());
            System.out.println(dellFactory.createKeyBoard());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}