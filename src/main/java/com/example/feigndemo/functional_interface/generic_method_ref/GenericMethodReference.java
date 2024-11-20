package com.example.feigndemo.functional_interface.generic_method_ref;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class GenericMethodReference {

    public static void main(String[] args) {
        Function<String[], List<String>> asList = Arrays::<String>asList;
        String[] arrays = {"1", "2", "3"};
        List<String> nameList = asList.apply(arrays);
        System.out.println(nameList);
    }
}
