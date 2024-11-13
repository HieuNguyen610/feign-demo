package com.example.feigndemo.concurrent_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatefulStreams {

    public static void main(String[] args) {
        var list = addValues(IntStream.range(1,11).parallel());
        var list2 = addValuesStateless(IntStream.range(1,11).parallel());
        System.out.println(list);
        System.out.println(list2);
    }

    /**
     * the lambda expression is stateful, making the result list is unordered.
     * @param source
     * @return
     */
    public static List<Integer> addValues (IntStream source) {
        var data = Collections.synchronizedList(new ArrayList<Integer>());
        source.filter(s -> s % 2 == 0).forEach(i -> data.add(i));
        return data;
    }

    public static List<Integer> addValuesStateless (IntStream source) {
        return source.filter(s -> s % 2 == 0).boxed().collect(Collectors.toList());
    }
}
