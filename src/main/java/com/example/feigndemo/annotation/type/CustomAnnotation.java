package com.example.feigndemo.annotation.type;

import com.example.feigndemo.annotation.inherited.A;
import com.example.feigndemo.annotation.inherited.Ann2;
import com.example.feigndemo.annotation.overriding.Animal;
import java.util.List;

public @interface CustomAnnotation {
    Class<? extends Animal> className();
    String[] strArray();

    Ann2 ann2();
}
