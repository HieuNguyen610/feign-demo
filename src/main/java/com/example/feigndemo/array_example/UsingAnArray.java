package com.example.feigndemo.array_example;

import java.util.Arrays;

public class UsingAnArray {

    public static void main(String[] args) {
        String[] mammals = {"monkey", "chimp", "donkey"};
        Arrays.sort(mammals);
        System.out.println(Arrays.toString(mammals));

        String[] strings = { "10", "9", "100" };
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
