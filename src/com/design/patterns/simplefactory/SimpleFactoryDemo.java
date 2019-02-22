package com.design.patterns.simplefactory;

/**
 * 简单工厂模式测试类
 * <p>
 * 简单工厂模式最大的优点在于工厂类中，包含了必要的逻辑判断，根据客户端的选择条件动态实例化相关的类，
 * 对于客户端来说，去除了与具体产品的依赖。就像之前使用简单工厂模式设计的计算器代码，客户端不用管该用
 * 哪个类的实例，只需要把相应的运算符号给工厂，工厂自动就给出了相应的实例，客户端只需要去做运算就可以了，
 * 不同的实例会实现不同的运算。当问题也就在这里，如果要加一个“求 M 数的 N 次方” 的功能，我们是一定需
 * 要给简单工厂类的方法里加分支条件的，这就等于说，我们不仅对扩展开发了，也对修改开放了，这样就违背了
 * 开-闭原则。而且如果简单工厂类里与创建对象相关的代码太多，也会导致耦合性高。
 * </p>
 *
 * @author wangyuheng
 * @date 2019-1-23
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        try {
            Operation add = SimpleFactory.createOperation("+");
            Operation sub = SimpleFactory.createOperation("-");
            Operation mul = SimpleFactory.createOperation("*");
            Operation div = SimpleFactory.createOperation("/");

            System.out.println(add.getResult(1, 1));
            System.out.println(sub.getResult(1, 1));
            System.out.println(mul.getResult(1, 1));
            System.out.println(div.getResult(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}