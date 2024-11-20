package com.example.feigndemo.generics;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public class UnboundWildcard {

    public static void printDetails(Wrapper<? extends Object> wrapper) {
        Object value = wrapper.getRef();
        String className = null;
        if (value != null) {
            className = value.getClass().getName();
        }
        System.out.println("Class: " + className);
        System.out.println("Value: " + value);
    }

    public static double sum(Wrapper<?> first, Wrapper<?> second) {
        Object firstValue = first.getRef();
        Object secondValue = second.getRef();
        if (firstValue instanceof Number && secondValue instanceof Number) {
            return ((Number) firstValue).doubleValue() + ((Number) secondValue).doubleValue();
        }
        return 0;
    }

    public static void main(String[] args) {
        Wrapper<Integer> intWrapper = new Wrapper<>(Integer.valueOf(10));
        Wrapper<? extends Number> numberWrapper = intWrapper;
    }
}
