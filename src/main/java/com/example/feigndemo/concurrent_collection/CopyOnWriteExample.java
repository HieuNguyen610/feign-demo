package com.example.feigndemo.concurrent_collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {

    public static void main(String[] args) {
        List<Integer> favNumbers = new CopyOnWriteArrayList<>(List.of(4,3,42));
        System.out.println(favNumbers);
        for (var n: favNumbers) {
            System.out.println(n + " ");
            favNumbers.add(n+1);
        }
        System.out.println(favNumbers);


    }
}
