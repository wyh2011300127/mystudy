package com.design.patterns.abstractfactory.pcfactory.factory;

import com.design.patterns.abstractfactory.pcfactory.entity.KeyBoard;
import com.design.patterns.abstractfactory.pcfactory.entity.Mouse;

/**
 * pc厂商，可以生产鼠标、键盘等等
 *
 * @author:wangyuheng
 * @date:2019/1/28 15:25
 */
public abstract class AbstractFactory {
    /**
     * 生产鼠标
     *
     * @return
     * @throws Exception
     */
    public abstract Mouse createMouse() throws Exception;

    /**
     * 生产键盘
     *
     * @return
     * @throws Exception
     */
    public abstract KeyBoard createKeyBoard() throws Exception;
}