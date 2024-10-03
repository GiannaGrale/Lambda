package com.udemy.lambda;


//SAM - single abstract method
@FunctionalInterface
public interface Greeting {
    String greet(String  name);
}
