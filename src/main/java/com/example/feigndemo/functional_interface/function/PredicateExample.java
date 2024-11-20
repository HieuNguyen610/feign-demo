package com.example.feigndemo.functional_interface.function;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> greaterThanTen = x -> x > 10;
        Predicate<Integer> divisibleToThree = x -> x % 3 == 0;
        Predicate<Integer> divisibleToFive = x -> x % 5 == 0;

        Predicate<Integer> lessThanOrEqualsTen = greaterThanTen.negate();
        Predicate<Integer> divisibleToThreeAndFive = divisibleToThree.and(divisibleToFive);
        Predicate<Integer> divisibleToThreeOrFive = divisibleToThree.or(divisibleToFive);

        System.out.println(lessThanOrEqualsTen.test(10));
        System.out.println(lessThanOrEqualsTen.test(11));
        System.out.println(lessThanOrEqualsTen.test(9));
        System.out.println(lessThanOrEqualsTen.test((int) 10.1));
    }
}
