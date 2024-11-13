package com.example.feigndemo.threadservice;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskExample {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        try {
            Runnable taskOne = () -> System.out.println("Checking lion cage");
            Runnable cleanCage = ()-> System.out.println("Clean cage");
            Callable<String> taskTwo = () -> "Feed the lion";
            ScheduledFuture<?> future1 = service.schedule(taskOne, 2, TimeUnit.SECONDS);
            ScheduledFuture<?> future2 = service.schedule(taskTwo, 2, TimeUnit.SECONDS);
            ScheduledFuture<?> cleanTheCage = service.scheduleAtFixedRate(cleanCage, 5, 5,   TimeUnit.SECONDS);

            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(cleanTheCage.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
            System.out.println("Finished! Shut down");
        }
    }
}
