package com.example.feigndemo.euler;

import java.util.stream.IntStream;

public class MultipleOf3And5 {

    public static void main(String[] args) {
        IntStream numberSmallerThan1000 = IntStream.range(1, 1000);
        long sum = numberSmallerThan1000.filter(n -> n % 3 == 0 || n % 5 == 0).sum();
        System.out.println(sum);
    }
}
