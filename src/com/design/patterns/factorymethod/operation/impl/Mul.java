package com.design.patterns.factorymethod.operation.impl;

import com.design.patterns.factorymethod.operation.Operation;

/**
 * 乘法类
 */
public class Mul implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA * numberB;
    }
}