package com.example.feigndemo.thread;

public class InterruptAThread {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                int count = 0;
                while(!Thread.interrupted()) {
                    System.out.println(name + ":" + count++);
                }
            }
        };

        Thread threadA = new Thread(r);
        Thread threadB = new Thread(r);

        threadA.start();
        threadB.start();

        try {
            Thread.sleep(2_000);
        } catch (Exception e) {

        }

        threadA.interrupt();
        threadB.interrupt();
    }
}
