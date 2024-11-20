package com.example.feigndemo.reflection;

import com.example.feigndemo.annotation.table.Test;
import org.bouncycastle.math.raw.Mod;

public class GetClassReference {

    public static void main(String[] args) throws ClassNotFoundException {
        // Get class reference using the class literal
        Class<Test> testClass = Test.class;
        System.out.println(testClass);

        Test testReference = new Test();
        Class<Test> testClass1 = (Class<Test>) testReference.getClass();
        System.out.println(testClass1);

        Class testClass2 = Class.forName("com.example.feigndemo.annotation.table.Test");
        System.out.println(testClass2);

        Module m = Test.class.getModule();
        Class testClass3 = Class.forName(m, "com.example.feigndemo.annotation.table.Test");
        System.out.println(testClass3);

    }
}
