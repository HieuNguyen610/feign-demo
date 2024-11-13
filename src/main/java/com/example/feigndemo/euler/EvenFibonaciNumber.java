package com.example.feigndemo.euler;

import java.util.ArrayList;
import java.util.List;

public class EvenFibonaciNumber {
        static long ceilLimit = 4_000_000;

    public static void main(String[] args) {
        List<Long> fibonumbers = new ArrayList<>();
        fibonumbers.add(1L);
        fibonumbers.add(2L);
        while (fibonumbers.get(fibonumbers.size() - 1) + fibonumbers.get(fibonumbers.size() - 2)
            <= ceilLimit) {
            fibonumbers.add(getFibonacci(fibonumbers.get(fibonumbers.size() - 1),
                fibonumbers.get(fibonumbers.size() - 2)));
        }
        System.out.println(fibonumbers);
        long sumOfEvenFibonacci = fibonumbers.stream().filter(num -> num%2 == 0).reduce(0l, (a, b) -> a + b);
        System.out.println(sumOfEvenFibonacci);
    }

    public static long getFibonacci(long first, long second) {
        if (first + second > ceilLimit) {
            throw new IllegalArgumentException("First and second exceed limit");
        }
        return first + second;
    }
}
