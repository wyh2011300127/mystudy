package com.design.patterns.abstractfactory.pcfactory.entity.impl;

import com.design.patterns.abstractfactory.pcfactory.entity.KeyBoard;

public class DellKeyBoard implements KeyBoard {
    public DellKeyBoard() {
        System.out.println("实例化戴尔键盘");
    }
}