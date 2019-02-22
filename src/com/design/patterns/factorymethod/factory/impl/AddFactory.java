package com.design.patterns.factorymethod.factory.impl;

import com.design.patterns.factorymethod.factory.Factory;
import com.design.patterns.simplefactory.Operation;
import com.design.patterns.simplefactory.impl.Add;

/**
 * 加法工厂，用于生产一个加法运算的对象
 */
public class AddFactory implements Factory {
    @Override
    public Operation createOperation() throws Exception {
        return new Add();
    }

}