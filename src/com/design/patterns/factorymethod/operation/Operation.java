package com.design.patterns.factorymethod.operation;

/**
 * 运算接口
 */
public interface Operation {
    double getResult(double numberA, double numberB) throws Exception;
}
