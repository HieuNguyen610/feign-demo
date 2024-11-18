package com.example.feigndemo.annotation.version;
import java.lang.annotation.Annotation;

public @interface Version {
    // abstract method in annotation is known as element
    // an annotation can declare zero or more elements and they are declared as abstract methods
    // static and default methods are not allowed in annotation, it cannot contains logic.
    int major() default 0;
    int minor() default 0;


}
