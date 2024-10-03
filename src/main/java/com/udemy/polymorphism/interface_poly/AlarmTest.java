package com.udemy.polymorphism.interface_poly;

public class AlarmTest {

    public static void main(String[] args) {
        Clock clock = new Clock();
        alarmTest(clock);

        IPhone iPhone = new IPhone();
        alarmTest(iPhone);

        GoogleMini googleMini = new GoogleMini();
        alarmTest(googleMini);
    }

    private static void alarmTest(Alarm a){
        a.setAlarm();
    }
}
