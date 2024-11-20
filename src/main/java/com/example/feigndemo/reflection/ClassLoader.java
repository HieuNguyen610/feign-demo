package com.example.feigndemo.reflection;

import com.example.feigndemo.annotation.table.Test;

public class ClassLoader {

    public static void main(String[] args) {
        Class<Test> cls = Test.class;
        java.lang.ClassLoader loader = cls.getClassLoader();

        System.out.println(loader.toString());
    }
}
