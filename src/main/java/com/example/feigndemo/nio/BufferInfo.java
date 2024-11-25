package com.example.feigndemo.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class BufferInfo {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(10);
        printBufferInfo(bb);
    }

    public static void printBufferInfo(Buffer bb) {

        System.out.println("Capacity: " + bb.capacity());
        System.out.println("Limit:" + bb.limit());
        System.out.println("Position: " + bb.position());

        try {
            bb.reset();
            System.out.println("After resetting, position: " + bb.position());
        } catch (InvalidMarkException e) {
            e.printStackTrace();
        }
    }

    public static void createDirectBuffer() {
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(10);
        System.out.println(directBuffer.isDirect());
    }


}
