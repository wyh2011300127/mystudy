package com.design.patterns.simplefactory.impl;

import com.design.patterns.simplefactory.Operation;

/**
 * 除法类
 */
public class Div implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        if (numberB == 0) {
            throw new Exception("除数不能为0");
        }
        return numberA / numberB;
    }
}