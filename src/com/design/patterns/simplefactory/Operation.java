package com.design.patterns.simplefactory;

/**
 * 提供运算的接口
 */
public interface Operation {
    double getResult(double numberA, double numberB) throws Exception;
}
