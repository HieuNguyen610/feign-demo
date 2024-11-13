package com.example.feigndemo.euler;

public class LargestPrimeFactor {

    public static void main(String[] args) {
        long number = 600851475143L;
        long largestPrime = findLargestPrimeFactor(number);
        System.out.println("The largest prime factor of " + number + " is: " + largestPrime);
    }

    private static long findLargestPrimeFactor(long number) {
        long largestPrime = 0;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                largestPrime = i;
                number /= i;
            }
        }
        if (number > 1) {
            largestPrime = number;
        }
        return largestPrime;
    }
}
