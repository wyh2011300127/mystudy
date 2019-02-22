package com.design.patterns.simplefactory.impl;

import com.design.patterns.simplefactory.Operation;

/**
 * 运算加法类
 */
public class Add implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA + numberB;
    }
}