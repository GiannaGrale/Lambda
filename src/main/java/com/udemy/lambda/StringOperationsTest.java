package com.udemy.lambda;

import java.util.ArrayList;
import java.util.List;

public class StringOperationsTest {

    private static final List<String> list = new ArrayList<>();
    public static void main(String[] args) {

        StringOperations operations =  list::add;
        operations.accept("udemy");
        System.out.println(list);

    }
}
