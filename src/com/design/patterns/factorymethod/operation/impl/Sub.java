package com.design.patterns.factorymethod.operation.impl;

import com.design.patterns.factorymethod.operation.Operation;

/**
 * 减法类
 */
public class Sub implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA - numberB;
    }
}