package com.example.feigndemo.threadservice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleOfLock {

    public static void main(String[] args) throws InterruptedException {
        ExampleOfLock example = new ExampleOfLock();
        Lock lock = new ReentrantLock();
        new Thread(() -> example.printHello(lock)).start();
        if (lock.tryLock(10, TimeUnit.SECONDS)) {
            try {
                System.out.println("Lock obtained, entering protected code");
            } finally {
                lock.unlock();
                System.out.println("Unlock");
            }
        }

        if (lock.tryLock(10, TimeUnit.SECONDS)) {
            System.out.println("Still locked");
        } else {
            System.out.println("Lock released");
        }
    }

    public void synchronizedExample() {
        Object object = new Object();
        synchronized (object) {

        }
    }

    public void lockMethod() {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(lock);
        } finally {
            lock.unlock();
            System.out.println(lock);
        }
    }

    public void printHello(Lock lock) {
        try {
            lock.lock();
            System.out.println("Hello");
        } finally {
            lock.unlock();
        }
    }
}
