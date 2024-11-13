package com.example.feigndemo.threadservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> result = service.submit(()-> 30 + 10);
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            service.shutdown();
            System.out.println("Service shut down");
        }
    }
}
