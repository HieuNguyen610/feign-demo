package com.example.feigndemo.threadservice;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionExample {

    public static void main(String[] args) {
        var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("tiger", 2);
        for (String key: foodData.keySet()) {
            foodData.remove(key);
            System.out.println(foodData);
        }

    }
}
