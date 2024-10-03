package com.udemy.datatype;

import java.util.Arrays;

public class Mutation {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        predict(array);
        totalSale(array);
    }

    //mutated here
    private static void predict(int[] a) {
        // to avoid mutation we create copy of array
        a = Arrays.copyOf(a, a.length);
        a[0]++;
        a[1]++;
        a[2]++;
        System.out.println("Prediction for next month || " + (a[0] + a[1] + a[2]));
    }

    private static void totalSale(int[] a) {
        System.out.println("Prediction for next month || " + (a[0] + a[1] + a[2]));
    }
}
