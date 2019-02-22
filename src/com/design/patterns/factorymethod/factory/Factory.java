package com.design.patterns.factorymethod.factory;

import com.design.patterns.simplefactory.Operation;

/**
 * 工厂方法接口类，用于创建Operation
 */
public interface Factory {
    Operation createOperation() throws Exception;
}
