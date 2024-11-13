package com.example.feigndemo.thread;

public class StopAThread {

    public static void main(String[] args) {
        class StoppableThread extends Thread {

            private boolean stopped;

            @Override
            public void run() {
                while (!stopped) {
                    System.out.println("Running...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            void stopThread() {
                stopped = true;
            }
        }
        StoppableThread stopThread = new StoppableThread();
        stopThread.start();
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopThread.stopThread();
        System.out.println(stopThread.getState());
    }
}
