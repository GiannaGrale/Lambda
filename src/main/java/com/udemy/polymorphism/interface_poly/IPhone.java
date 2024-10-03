package com.udemy.polymorphism.interface_poly;

public class IPhone implements Alarm {

    public void call() {
        System.out.println("Call someone");
    }

    @Override
    public void setAlarm() {
        System.out.println("Set alarm at 7-10 AM");
    }
}
