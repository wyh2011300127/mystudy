package com.design.patterns.abstractfactory.demo;

import com.design.patterns.abstractfactory.demo.entiry.Color;
import com.design.patterns.abstractfactory.demo.factory.AbstractFactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory color = FactoryProducer.getFactory("color");
        Color red = color.getColor("red");
        red.fill();
    }
}