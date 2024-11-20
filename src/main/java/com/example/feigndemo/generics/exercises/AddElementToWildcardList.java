package com.example.feigndemo.generics.exercises;

import java.util.ArrayList;
import java.util.List;

public class AddElementToWildcardList {

    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
//        list.add(new Object());
        list.add(null);
    }
}
