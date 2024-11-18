package com.example.feigndemo.annotation.custom;

public class MyClass {

    @MyCustomAnnotation(studentName = "Harry", studentAddress = "Hanoi")
    public void myMethod() {
        System.out.println("myMethod implementation");
    }

}
