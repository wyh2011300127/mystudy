package com.design.patterns.factorymethod.factory.impl;

import com.design.patterns.factorymethod.factory.Factory;
import com.design.patterns.simplefactory.Operation;
import com.design.patterns.simplefactory.impl.Sub;

/**
 * 减法工厂，用于生产一个剪发运算的对象
 */
public class SubFactory implements Factory {

    @Override
    public Operation createOperation() throws Exception {
        return new Sub();
    }
}