package com.udemy.polymorphism.interface_poly;

public class GoogleMini implements Alarm {

    public void ask() {
        System.out.println("How is the weather today?");
    }

    @Override
    public void setAlarm() {
        System.out.println("Set alarm at 8-40 AM");
    }
}
