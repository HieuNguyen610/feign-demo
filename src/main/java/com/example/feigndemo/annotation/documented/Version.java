package com.example.feigndemo.annotation.documented;

import com.example.feigndemo.annotation.repeatable.TestClass;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE_USE)
public @interface Version {
    int major() default 0;
    int minor() default 0;
}
