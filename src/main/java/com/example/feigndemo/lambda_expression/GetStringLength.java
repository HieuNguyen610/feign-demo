package com.example.feigndemo.lambda_expression;

public class GetStringLength {

    public static void main(String[] args) {
        StringLength stringLength = (String str) -> str.length();
        System.out.println(stringLength.length("Hello World")); // Output: 11
    }
}

@FunctionalInterface
interface StringLength {
    int length(String str);
}
