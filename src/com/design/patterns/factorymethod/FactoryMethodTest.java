package com.design.patterns.factorymethod;

import com.design.patterns.factorymethod.factory.Factory;
import com.design.patterns.factorymethod.factory.impl.AddFactory;
import com.design.patterns.factorymethod.factory.impl.DivFactory;
import com.design.patterns.factorymethod.factory.impl.MulFactory;
import com.design.patterns.factorymethod.factory.impl.SubFactory;
import com.design.patterns.simplefactory.Operation;

/**
 * 工厂方法模式测试类
 * <p>
 * 工厂方法模式实现时，客户端需要决定实例化哪一个工厂来实现运算类，选择判断的问题还是存在的，
 * 也就是说，工厂方法把简单工厂的内部逻辑判断转移到了客户端代码来进行。你想要加功能，本来是改工厂类的，
 * 而现在是修改客户端。而且各个不同功能的实例对象的创建代码，也没有耦合在同一个工厂类里，
 * 这也是工厂方法模式对简单工厂模式解耦的一个体现。工厂方法模式克服了简单工厂会违背开-闭原则的缺点，
 * 又保持了封装对象创建过程的优点。所以它们都是集中封装了对象的创建，使得要更换对象时，
 * 不需要做大的改动就可以实现，降低了客户程序与产品对象的耦合。工厂方法模式是简单工厂模式的进一步抽象
 * 和推广。由于使用了多态性，工厂方法模式保持了简单工厂模式的优点，而且克服了它的缺点。
 * 但工厂方法模式的缺点是每增加一个产品类，就需要增加一个对应的工厂类，增加了额外的开发量。
 * </p>
 *
 * @author wangyuheng
 * @date 2019-1-23
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        try {
            //创建工厂实例
            Factory addFactory = new AddFactory();
            Factory subFactory = new SubFactory();
            Factory mulFactory = new MulFactory();
            Factory divFactory = new DivFactory();

            //创建运算
            Operation add = addFactory.createOperation();
            Operation sub = subFactory.createOperation();
            Operation mul = mulFactory.createOperation();
            Operation div = divFactory.createOperation();
            //进行运算
            System.out.println(add.getResult(4, 2));
            System.out.println(sub.getResult(4, 2));
            System.out.println(mul.getResult(4, 2));
            System.out.println(div.getResult(4, 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}