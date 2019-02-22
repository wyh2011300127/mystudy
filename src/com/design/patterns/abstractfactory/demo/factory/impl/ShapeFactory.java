package com.design.patterns.abstractfactory.demo.factory.impl;

import com.design.patterns.abstractfactory.demo.entiry.Color;
import com.design.patterns.abstractfactory.demo.entiry.Shape;
import com.design.patterns.abstractfactory.demo.entiry.shape.Circle;
import com.design.patterns.abstractfactory.demo.entiry.shape.Rectangle;
import com.design.patterns.abstractfactory.demo.entiry.shape.Square;
import com.design.patterns.abstractfactory.demo.factory.AbstractFactory;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if ("rectangle".equalsIgnoreCase(shape)) {
            return new Rectangle();
        }
        if ("square".equalsIgnoreCase(shape)) {
            return new Square();
        }
        if ("circle".equalsIgnoreCase(shape)) {
            return new Circle();
        }
        return null;
    }
}