package com.example.feigndemo.concurrent_collection;

import java.util.concurrent.Executors;

public class FoxyAndTail {

    public static void main(String[] args) {
        var foxy = new Fox("foxy");
        var tail = new Fox("tail");
        var food = new Food();
        var water = new Water();
        var service = Executors.newScheduledThreadPool(10);
        try {
            service.submit(()-> foxy.eatAndDrink(food, water));
            service.submit(()-> tail.eatAndDrink(food, water));
        } finally {
            service.shutdown();
        }

    }

}

record Fox(String name) {
    public void eatAndDrink(Food food, Water water) {
        synchronized (food) {
            System.out.println(name() + " got food");
            move();
            synchronized (water) {
                System.out.println(name() + " got water");
                move();
            }
        }
    }

    public void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.println(name() + " got water");
            move();
            synchronized (food) {
                System.out.println(name() + " got food");
                move();
            }
        }
    }

    public void move() {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
    }
}



class Water {

}

class Food {

}