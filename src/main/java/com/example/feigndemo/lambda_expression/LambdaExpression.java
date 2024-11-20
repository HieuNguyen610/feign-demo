package com.example.feigndemo.lambda_expression;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.Objects;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class LambdaExpression {

    public static void main(String[] args) {
        Adder adder = (a, b) -> a + b;
        Joiner joiner = (a, b) -> a + b;

        System.out.println(adder.add(1,2));
        System.out.println(joiner.join("a", "b"));
    }
}

@FunctionalInterface
interface Adder{
    double add(double first, double second);
    boolean equals(Object object);
}

@FunctionalInterface
interface Joiner {
    String join(String first, String second);
}
