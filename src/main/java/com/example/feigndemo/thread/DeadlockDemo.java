package com.example.feigndemo.thread;

import java.util.concurrent.locks.Lock;

public class DeadlockDemo {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void instanceMethod1() {
        synchronized (lock1) {
            System.out.println("Thread 1: acquired lock1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println("Thread 1: acquired lock2");
            }
        }
    }

    public void instanceMethod2() {
        synchronized (lock2) {
            System.out.println("Thread 2: acquired lock2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("Thread 2: acquired lock1");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadlockDemo demo = new DeadlockDemo();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    demo.instanceMethod1();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    demo.instanceMethod2();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        Thread.sleep(1000);
        t2.start();

    }
}
