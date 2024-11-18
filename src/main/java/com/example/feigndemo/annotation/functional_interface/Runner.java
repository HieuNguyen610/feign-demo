package com.example.feigndemo.annotation.functional_interface;

@FunctionalInterface
public interface Runner {
    void run();

    private void secret() {
        System.out.println("Runner.secret()");
    }

    public default void defaultMethod() {
        System.out.println("Runner.defaultMethod()");
    }
}
