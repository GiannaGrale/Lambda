package com.udemy.polymorphism;

public class TestMain {

    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();

        System.out.println(areaCalculator.getArea(4));
        System.out.println(areaCalculator.getArea(4.5));
        System.out.println(areaCalculator.getArea(6, 5));
    }
}
