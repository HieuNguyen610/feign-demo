package com.example.feigndemo.annotation.overriding;

public class Animal {
    public void makeSound(int times) {
        System.out.println("Animal makes a sound " + times + " times");
    }

    public void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound(int times) {
        System.out.println("Dog barks " + times + " times");
    }

    @Override
    public void eat() {
        System.out.println("Dog eat");
    }
}
