package com.example.feigndemo.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class CreateARunnable {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread run");
    }
}
