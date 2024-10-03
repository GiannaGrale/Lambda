package com.udemy.lambda.assignment;

public class MathOperationsTest {

    public static void main(String[] args) {
        int result;
        MathOperations m1 = Math::addExact;
        result = calculate(5, m1, 2);

        MathOperations m2 = Math::subtractExact;
        result = calculate(result, m2, 3);

        MathOperations m3 = Math::multiplyExact;
        result = calculate(result, m3, 7);
        result = calculate(result, m1, 2);

        MathOperations m4 = Math::floorDiv;
        result = calculate(result, m4, 3);
        System.out.println(result);

        String exp = "9 * 9 - 1 * 7 / 8 + 30 ^ 2 % 3";
        Calculator.addOperation("^", (a, b) -> (int) Math.pow(a, b));
        Calculator.addOperation("%", (a, b) -> a % b);

        System.out.println("Calculator result :: " + Calculator.calculate(exp));

    }

    private static int calculate(int onScreenNumber, MathOperations mathOperations, int enteredNumber) {
        return mathOperations.operate(onScreenNumber, enteredNumber);

    }
}
