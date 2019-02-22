package com.design.patterns.abstractfactory.pcfactory.factory.impl;

import com.design.patterns.abstractfactory.pcfactory.entity.KeyBoard;
import com.design.patterns.abstractfactory.pcfactory.entity.Mouse;
import com.design.patterns.abstractfactory.pcfactory.entity.impl.LenovoKeyBoard;
import com.design.patterns.abstractfactory.pcfactory.entity.impl.LenovoMouse;
import com.design.patterns.abstractfactory.pcfactory.factory.AbstractFactory;

/**
 * 联想工厂
 *
 * @author:wangyuheng
 * @date:2019/1/28 15:24
 */
public class LenovoFactory extends AbstractFactory {
    @Override
    public Mouse createMouse() throws Exception {
        //生产联想鼠标
        return new LenovoMouse();
    }

    @Override
    public KeyBoard createKeyBoard() throws Exception {
        //生产联想键盘
        return new LenovoKeyBoard();
    }
}