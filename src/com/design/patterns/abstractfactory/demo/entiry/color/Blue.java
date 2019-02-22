package com.design.patterns.abstractfactory.demo.entiry.color;

import com.design.patterns.abstractfactory.demo.entiry.Color;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("new Blue().fill()");
    }
}