package com.example.feigndemo.annotation.table;

import com.example.feigndemo.annotation.repeatable.ChangeLogs;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;


@Repeatable(Authors.class)
@Target({ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.METHOD})
public @interface Author {
    String firstName();
    String lastName();
}
