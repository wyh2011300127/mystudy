package com.design.patterns.factorymethod.operation.impl;

import com.design.patterns.factorymethod.operation.Operation;

/**
 * 加法类
 */
public class Add implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA + numberB;
    }
}