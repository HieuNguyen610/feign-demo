package com.example.feigndemo.threadservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FeedLion {

    private int feedLionCount = 0;

    public static void main(String[] args) {
        FeedLion feedLion = new FeedLion();
        feedLion.feedLion();
    }

    public void feedLionReport() {
        synchronized (this) {
            System.out.print(++feedLionCount + " ");
        }
    }

    public synchronized void feedLionReportSynchronized() {
        System.out.print(++feedLionCount + " ");
    }

    public void feedLion() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            for (int i = 0; i < 100; i++) {
                executorService.execute(() -> feedLionReportSynchronized());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            while (executorService != null) {

            }
            System.out.println("Finished! Shut down");
        }
    }
}
