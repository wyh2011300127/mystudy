package com.design.patterns.abstractfactory.demo.entiry.shape;

import com.design.patterns.abstractfactory.demo.entiry.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("new Circle().draw()");

    }
}