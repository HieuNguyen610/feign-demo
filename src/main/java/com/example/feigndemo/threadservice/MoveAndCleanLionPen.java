package com.example.feigndemo.threadservice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class MoveAndCleanLionPen {

    public static void main(String[] args) {
        var service = Executors.newFixedThreadPool(4);
        try {
            var manager = new MoveAndCleanLionPen();
            var cyclicBarrier1 = new CyclicBarrier(4);
            var cyclicBarrier2 = new CyclicBarrier(4);
            for (int i = 0; i < 4; i++) {
                service.submit(()-> {
                    try {
                        manager.performTasks(cyclicBarrier1, cyclicBarrier2);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } finally {
            service.shutdown();
        }
    }
    
    public void performTasks(CyclicBarrier cyclicBarrier1, CyclicBarrier cyclicBarrier2)
        throws BrokenBarrierException, InterruptedException {
        moveLion();
        cyclicBarrier1.await();
        cleanLionPen();
        cyclicBarrier2.await();
        addLion();
    }

    private void addLion() {
        System.out.println("Add lion into pen");
    }

    private void cleanLionPen() {
        System.out.println("clean the pen");
    }

    private void moveLion() {
        System.out.println("Remove lion from pen");
    }
}
