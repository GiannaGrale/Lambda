package com.udemy.datatype;

import java.util.Arrays;

public class ReferenceType {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};//new object is created, has its own reference
        System.out.println("Before || " + Arrays.toString(array));
        change(array);
        System.out.println("After || " + Arrays.toString(array));

    }

    //the copy of the reference goes here
    private static void change(int[] a) {
        a[0]++;
        a[1]++;
        a[2]++;
    }
}
