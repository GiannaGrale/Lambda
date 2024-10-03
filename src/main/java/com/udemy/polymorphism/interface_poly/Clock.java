package com.udemy.polymorphism.interface_poly;

import java.time.LocalDate;

public class Clock implements Alarm {

    public void  showTime(){
        System.out.println("Current time " + LocalDate.now());
    }
    @Override
    public void setAlarm() {
        System.out.println("Set alarm at 9-00 AM");
    }
}
