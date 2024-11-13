package com.example.feigndemo.threadservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {

    private int sheepCount;
    private void incrementAndReport() {
        synchronized (this) {
            System.out.println(++sheepCount + " ");
        }
    }

    public static void main(String[] args) {
        SheepManager sheepManager = new SheepManager();
        sheepManager.synchronizeExecution();
    }

    private static void extracted() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            SheepManager sheepManager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                executorService.submit(sheepManager::incrementAndReport);
            }
        } catch (Exception e) {

        } finally {
            executorService.shutdown();
            while (!executorService.isTerminated()) {
                // Wait for the executor to finish all tasks
            }
            System.out.println("All tasks are finished");
        }
    }

    /**
     * synchronized the creation of thread, but not the execution, result in unordered execution
     */
    public static void executeSynchronously() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
            SheepManager sheepManager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                synchronized (sheepManager) {
                    executor.submit(()-> sheepManager.incrementAndReport());
                }
            }
        } catch (Exception e) {}
        finally {
            executor.shutdown();
            while (!executor.isTerminated()) {
                // Wait for the executor to finish all tasks
            }
            System.out.println("All tasks are finished");    
        }
    }

    public void synchronizeExecution() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            SheepManager sheepManager = new SheepManager();
            for (int i = 0; i < 10; i++) {
                    service.submit(()-> sheepManager.incrementAndReport());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
            while (!service.isTerminated()) {
                // Wait for the executor to finish all tasks
            }
            System.out.println("All tasks are finished");
        }
    }
}
