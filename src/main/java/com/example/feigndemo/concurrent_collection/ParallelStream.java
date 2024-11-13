package com.example.feigndemo.concurrent_collection;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {
        Collection<Integer> integers = List.of(1,2,3,4);

        Stream<Integer> integerStream = integers.stream().parallel();
        Stream<Integer> parallelStream = integers.parallelStream();

        long start = System.currentTimeMillis();
        integers.parallelStream().map(w-> doWork(w)).forEach(s -> System.out.print(s + " "));
        System.out.println();
        var timeTaken = System.currentTimeMillis() - start;
        System.out.println("Time taken: " + timeTaken + " ms");
    }

    public static int doWork(int input) {
        try {
            Thread.sleep(5_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }
}
