package com.example.feigndemo.thread;

import org.springframework.data.util.Optionals;

public class CreateAThreadName {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("-----New Runnable----");
        Thread thread = new Thread(r, "thread 1");
        thread.setDaemon(true);

        showStatus(thread);

        thread.start();
        showStatus(thread);

    }

    public static void showStatus(Thread thread) {
        System.out.println("------------");
        System.out.println("Thread name:" + thread.getName());;
        System.out.println("thread is alive: " + thread.isAlive());
        System.out.println("thread current state:  " + thread.getState());
        System.out.println("available processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Current priority: " + thread.getPriority());
        System.out.println("Is daemon: " + thread.isDaemon());
    }
}
