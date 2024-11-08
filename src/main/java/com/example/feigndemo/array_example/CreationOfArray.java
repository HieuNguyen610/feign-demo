package com.example.feigndemo.array_example;

import java.util.Arrays;

public class CreationOfArray {

    public static void main(String[] args) {
        int[] intArray = new int[10];
        intArray[0] = 1;
        intArray[1] = 2;
        intArray[2] = 3;

        int[] another = new int[] { 1, 2, 3 };

        System.out.println(another.length);

        System.out.println(intArray.length);

        int[] first, second;
        String[] bugs = {"cricket", "beetle", "ant"};
        String[] alias = bugs;
        System.out.println(bugs == alias);
        Arrays.stream(alias).forEach(System.out::println);


    }
}
