package com.design.patterns.simplefactory.impl;

import com.design.patterns.simplefactory.Operation;

/**
 * 乘法类
 */
public class Mul implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA * numberB;
    }
}