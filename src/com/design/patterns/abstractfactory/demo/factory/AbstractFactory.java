package com.design.patterns.abstractfactory.demo.factory;

import com.design.patterns.abstractfactory.demo.entiry.Color;
import com.design.patterns.abstractfactory.demo.entiry.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}