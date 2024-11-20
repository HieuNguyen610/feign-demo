package com.example.feigndemo.inner_classes;

public class Outer {
    private int value = 101;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public class Inner {
        private int value = 201;
    }
}
