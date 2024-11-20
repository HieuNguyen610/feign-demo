package com.example.feigndemo.inner_classes.exercises;

public class Cup {
    public class Handle {
        public Handle() {
            System.out.println("Create handler for cup");
        }
    }
    public Cup() {
        System.out.println("Create a cup");
    }
}

class CupTest {
    public static void main(String[] args) {
        Cup cup = new Cup();
        Cup.Handle handle = cup.new Handle();
    }
}
