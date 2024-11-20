package com.example.feigndemo.inner_classes.anonymous_inner_class;

public class HelloAnonymous {

    public static void main(String[] args) {
        new Object() {
            {
                System.out.println("Hello from anonymous");
            }
        };
    }
}
