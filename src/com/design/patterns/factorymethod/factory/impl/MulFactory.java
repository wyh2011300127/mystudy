package com.design.patterns.factorymethod.factory.impl;

import com.design.patterns.factorymethod.factory.Factory;
import com.design.patterns.simplefactory.Operation;
import com.design.patterns.simplefactory.impl.Mul;

/**
 * 乘法工厂，用于生产一个乘法运算的对象
 */
public class MulFactory implements Factory {

    @Override
    public Operation createOperation() throws Exception {
        return new Mul();
    }
}