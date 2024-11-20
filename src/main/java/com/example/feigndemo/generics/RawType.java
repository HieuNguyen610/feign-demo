package com.example.feigndemo.generics;

public class RawType {

    public static void main(String[] args) {
        Wrapper raw = new Wrapper("Hello");
        Wrapper<String> generic = new Wrapper<>("Hello generic");
        generic = raw;
        raw = generic;
    }
}
