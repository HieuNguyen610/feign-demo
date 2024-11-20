package com.example.feigndemo.functional_interface.function;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class FunctionExample {

    public static void main(String[] args) {
        Function<Integer, Integer> square =  x -> x * x;
        IntFunction<Integer> square2 = x -> x * x;
        ToIntFunction<Integer> square3 = x -> x * x;
        UnaryOperator<Integer> square4 = x -> x * x;
        Function<Integer, Integer> addOne = x -> x + 1;

        Function<Integer, Integer> squareThenAddOne = square.andThen(addOne);
        Function<Integer, Integer> minusOne = x -> x - 1;
        Function<Integer, Integer> squareThenMinusOne = square.andThen(minusOne);
        int result = squareThenAddOne.apply(3);
        System.out.println(result);
        System.out.println(squareThenMinusOne.apply(2));

    }
}
