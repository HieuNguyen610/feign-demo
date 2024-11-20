package com.example.feigndemo.generics;

import ch.qos.logback.core.model.INamedModel;

public class MethodAndConstructor<T> {
    public <V> void m1(Wrapper<V> a, Wrapper<V> b, T c) {
        System.out.println("method1: " + a + ", " + b + ", " + c);
    }

    public <U extends T> MethodAndConstructor( U u) {
        System.out.println("constructor: " + u);
    }

    public static void main(String[] args) {
        MethodAndConstructor<String> t = new MethodAndConstructor<>("World");

        Wrapper<Integer> iw1 = new Wrapper<>(Integer.valueOf(201));
        Wrapper<Integer> iw2 = new Wrapper<>(Integer.valueOf(202));

        t.<Integer>m1(iw1, iw2, "Hello");
        t.m1(iw1, iw2, "hello");
    }
}
