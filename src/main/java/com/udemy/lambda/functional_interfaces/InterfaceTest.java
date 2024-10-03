package com.udemy.lambda.functional_interfaces;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class InterfaceTest {

    public static void main(String[] args) {
        Supplier<Double> random = Math::random;
        System.out.println(random.get());

        Consumer<String> c1 = System.out::println;
        c1.accept("udemy");
    }
}
