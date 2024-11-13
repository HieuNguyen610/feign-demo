package com.example.feigndemo.threadservice;

import java.io.FilterOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class WaitingAllTasksFinish {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> result = service.submit(()-> 10 + 10);
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
        service.awaitTermination(1, TimeUnit.SECONDS);
        if (service.isTerminated()) {
            System.out.println("Terminated service");
        } else {
            System.out.println("At least one task is still running");
        }
    }
}
