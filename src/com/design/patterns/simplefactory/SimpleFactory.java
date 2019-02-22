package com.design.patterns.simplefactory;

import com.design.patterns.simplefactory.impl.Add;
import com.design.patterns.simplefactory.impl.Div;
import com.design.patterns.simplefactory.impl.Mul;
import com.design.patterns.simplefactory.impl.Sub;

/**
 * 简单工厂
 */
public class SimpleFactory {
    public static Operation createOperation(String type) throws Exception {
        // 简单工厂，根据字符串创建相应的对象
        Operation operationObj = null;
        switch (type) {
            case "+":
                operationObj = new Add();
                break;
            case "-":
                operationObj = new Sub();
                break;
            case "*":
                operationObj = new Mul();
                break;
            case "/":
                operationObj = new Div();
                break;
        }
        return operationObj;
    }
}