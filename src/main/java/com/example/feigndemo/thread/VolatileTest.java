package com.example.feigndemo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VolatileTest {
    private static final Logger logger = LoggerFactory.getLogger(VolatileTest.class);
    public static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        public void run() {
            int localInt = MY_INT;
            while( localInt < 5) {
                if (localInt != MY_INT) {
                    logger.info("Got change for MY_INT: {}", MY_INT);
                    localInt = MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread {
        public void run() {
            int localInt = MY_INT;
            while(localInt < 5) {
                logger.info("Increase MY_INT to {}", localInt + 1);
                MY_INT = ++localInt;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}


