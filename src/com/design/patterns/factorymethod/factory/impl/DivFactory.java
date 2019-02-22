package com.design.patterns.factorymethod.factory.impl;

import com.design.patterns.factorymethod.factory.Factory;
import com.design.patterns.simplefactory.Operation;
import com.design.patterns.simplefactory.impl.Div;

/**
 * 除法工厂，用于生产一个除法运算的对象
 */
public class DivFactory implements Factory {
    @Override
    public Operation createOperation() throws Exception {
        return new Div();
    }
}