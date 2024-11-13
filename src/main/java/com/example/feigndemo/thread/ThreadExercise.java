package com.example.feigndemo.thread;

public class ThreadExercise {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            while (true) {
                System.out.println("hello");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                    break;
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();
        try {
            thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();

    }

}
