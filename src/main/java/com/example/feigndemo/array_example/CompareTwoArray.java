package com.example.feigndemo.array_example;

import java.util.Arrays;

public class CompareTwoArray {

    public static void main(String[] args) {
        int[] array1 = {2, 2, 3, 4, 5, 6, Integer.MIN_VALUE};
        int[] array2 = {2, 2, 3, 4, 5, 6};

        System.out.println(array1 == array2); // false
        System.out.println(array1.equals(array2)); // true
        System.out.println(Arrays.compare(array1, array2)); // -1 means array1 smaller
    }
}
