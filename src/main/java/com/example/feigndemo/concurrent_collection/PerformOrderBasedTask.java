package com.example.feigndemo.concurrent_collection;

import java.util.List;

public class PerformOrderBasedTask {

    public static void main(String[] args) {
        System.out.println(List.of(1,2,3,4,5,6).stream().unordered().parallel().findFirst().get());
    }
}
