package com.design.patterns.simplefactory.impl;

import com.design.patterns.simplefactory.Operation;

public class Sub implements Operation {


    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA - numberB;
    }
}