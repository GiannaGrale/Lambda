package com.udemy.lambda.assignment;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private static Map<String, MathOperations> map = new HashMap<>();

    static {
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("/", (a, b) -> a / b);
        map.put("*", (a, b) -> a * b);
    }

    public static void addOperation(String key, MathOperations mathOperations) {
        map.put(key, mathOperations);
    }

    public static int calculate(String expressing) {
        String[] str = expressing.split(" ");
        int onScreenNumber = Integer.parseInt(str[0]);
        for (int i = 1; i < str.length; i = i + 2) {
            MathOperations op = map.get(str[i]);
            int enteredNumber = Integer.parseInt(str[i + 1]);
            onScreenNumber = calculate(onScreenNumber, op, enteredNumber);
        }
        return onScreenNumber;

    }

    private static int calculate(int onScreenNumber, MathOperations mathOperations, int enteredNumber) {
        return mathOperations.operate(onScreenNumber, enteredNumber);

    }
}
