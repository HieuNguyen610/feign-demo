package com.example.feigndemo.string_example;

public class StringExample {

    public static void main(String[] args) {
        String one = "1";
        var first = "var" + one;
        var second = "v" + "a" + "r" + one;
        var third = "v" + "a" + "r" + new String("1");
        System.out.println(first == second);
        System.out.println(first == second.intern());
        System.out.println(first == third);
        System.out.println(first == third.intern());
    }
}
