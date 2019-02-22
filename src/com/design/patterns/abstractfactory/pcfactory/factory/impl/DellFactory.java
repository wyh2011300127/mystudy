package com.design.patterns.abstractfactory.pcfactory.factory.impl;

import com.design.patterns.abstractfactory.pcfactory.entity.KeyBoard;
import com.design.patterns.abstractfactory.pcfactory.entity.Mouse;
import com.design.patterns.abstractfactory.pcfactory.entity.impl.DellKeyBoard;
import com.design.patterns.abstractfactory.pcfactory.entity.impl.DellMouse;
import com.design.patterns.abstractfactory.pcfactory.factory.AbstractFactory;

/**
 * 戴尔工厂
 *
 * @author:wangyuheng
 * @date:2019/1/28 15:23
 */
public class DellFactory extends AbstractFactory {

    @Override
    public Mouse createMouse() throws Exception {
        //生产戴尔鼠标
        return new DellMouse();
    }

    @Override
    public KeyBoard createKeyBoard() throws Exception {
        //生产戴尔键盘
        return new DellKeyBoard();
    }
}