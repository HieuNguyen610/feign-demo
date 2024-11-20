package com.example.feigndemo.functional_interface.constructor_reference;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String[] args) {
        Supplier<String> createString = () -> new String();
        Supplier<String> createString2 = String::new;
        Function<String, String> createStringFunction = (str)-> new String(str);
        Function<String, String> createStringFunction2 = String::new;
    }
}
