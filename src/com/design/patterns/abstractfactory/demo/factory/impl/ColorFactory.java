package com.design.patterns.abstractfactory.demo.factory.impl;

import com.design.patterns.abstractfactory.demo.entiry.Color;
import com.design.patterns.abstractfactory.demo.entiry.Shape;
import com.design.patterns.abstractfactory.demo.entiry.color.Blue;
import com.design.patterns.abstractfactory.demo.entiry.color.Green;
import com.design.patterns.abstractfactory.demo.entiry.color.Red;
import com.design.patterns.abstractfactory.demo.factory.AbstractFactory;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null) {
            System.out.println("color == null");
        }
        if ("red".equalsIgnoreCase(color)) {
            return new Red();
        }
        if ("blue".equalsIgnoreCase(color)) {
            return new Blue();
        }
        if ("green".equalsIgnoreCase(color)) {
            return new Green();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}