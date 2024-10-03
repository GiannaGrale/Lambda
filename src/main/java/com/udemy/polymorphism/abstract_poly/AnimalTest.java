package com.udemy.polymorphism.abstract_poly;

public class AnimalTest {

    public static void main(String[] args) {
        Animal a = new Dog();
        test(a);

        a = new Cat();
        test(a);

        a = new Horse();
        test(a);

    }

    public static void test(Animal animal) {
        animal.makeSound();
        animal.walk();
    }
}
