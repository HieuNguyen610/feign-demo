package com.example.feigndemo.array_example;

import static java.util.Arrays.binarySearch;

public class SearchingArray {

    public static void main(String[] args) {
        int[] numbers = {10, 7, 6,5, 0};
        int target = 7;
        int index = binarySearch(numbers, target);
        System.out.println(index);
    }
}
