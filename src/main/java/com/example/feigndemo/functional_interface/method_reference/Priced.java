package com.example.feigndemo.functional_interface.method_reference;

public interface Priced {
    public default double getPrice() {
        return 1.0;
    }
}
