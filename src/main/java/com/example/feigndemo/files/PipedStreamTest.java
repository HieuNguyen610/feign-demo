package com.example.feigndemo.files;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamTest {

    public static void main(String[] args) {
        try (PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream();){

            pos.connect(pis);

            Runnable producer = () -> produceData(pos);
            Runnable consumer = () -> consumeData(pis);
            Thread producerThread = new Thread(producer);
            Thread consumerThread = new Thread(consumer);

            producerThread.start();
            consumerThread.start();

            producerThread.join();
            consumerThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void produceData(PipedOutputStream pos) {
        try {
            for (int i = 0; i < 50; i++) {
                pos.write((byte) i);
                pos.flush();
                System.out.println("Writing: " + i);
                Thread.sleep(500);
            }
            pos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void consumeData(PipedInputStream pis) {
        try {
            int num = -1;
            while ((num = pis.read())!= -1) {
                System.out.println("Reading: " + num);
                Thread.sleep(500);
            }
            pis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
