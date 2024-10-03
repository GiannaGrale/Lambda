package com.udemy.lambda;

public class GreetingTest {

    public static void main(String[] args) {
        Greeting greeting = (name) -> "Hello " + name;
        greeting.greet("Anna");

        Greeting hiService = (name) -> "Hello " + name.toUpperCase();

        hiService.greet("Anna");
        String s = getLambda().greet("data");
        System.out.println(s);

    }

    public static Greeting getLambda(){
       // Greeting g = (s) -> s.toUpperCase();
        return (s) -> s.toUpperCase();

    }
}
