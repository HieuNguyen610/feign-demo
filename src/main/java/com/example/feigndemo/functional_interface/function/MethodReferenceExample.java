package com.example.feigndemo.functional_interface.function;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {

    public static void main(String[] args) {
        Function<Integer, String> integerToString = x -> Integer.toBinaryString(x);
        Function<Integer, String> integerToString2 = Integer::toBinaryString;


        BiFunction<Integer, Integer, Integer> sum = ( a,  b) -> Integer.sum(a, b);
        BiFunction<Integer, Integer, Integer> sumMR = Integer::sum;

        System.out.println(integerToString.apply(10));
        System.out.println(integerToString2.apply(10));
        System.out.println(sum.apply(1,2));
        System.out.println(sumMR.apply(1,2));

    }
}
