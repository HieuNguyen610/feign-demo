package com.example.feigndemo.thread;

public class RaceConditionExample {

    private static int counter = 0;

    public static void main(String[] args) {
        Runnable r = () -> {
            getID();
        };
        Runnable r2 = () -> {
           getID();
        };
        Thread t = new Thread(r);
        Thread t2 = new Thread(r2);
        t.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println(counter);
    }

    public static int getID()
    {
        return counter++;
    }
}
