package com.example.feigndemo.thread;

public class NotifyExample {

    public static void main(String[] args) {
        CustomThread customThread = new CustomThread();
        CustomThread notifyThread = new CustomThread();
        customThread.start();
        synchronized (customThread) {
            try {
                System.out.println("Wait custom thread to complete");
                System.out.println(customThread.getState());
                customThread.wait();
                System.out.println(customThread.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Total is: " + customThread.total);
        }
        System.out.println(customThread.getState());

//        notifyThread.start();
//        synchronized (notifyThread) {
//            notifyThread.notify();
//        }

        System.out.println(customThread.getState());


    }
}

class CustomThread extends Thread {
    int total;
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                total += i;
            }
            notify();
        }
    }
}
