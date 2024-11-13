package com.example.feigndemo.thread;

public class LockExample {

    private int counter;
    public synchronized int getCounter() {
        return ++counter;
    }

    public static void main(String[] args) {
//        Runnable r = () -> System.out.println("Runnable");
//        Thread t = new Thread(r);
//        t.start();

        LockExample lockExample = new LockExample();
        lockExample.getCounter();
        System.out.println(lockExample.counter);

    }
}
