package com.example.feigndemo.compression.checksum;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class CreateBuffer {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(8);
        int capacity = bb.capacity();

        CharBuffer cb = CharBuffer.allocate(1024);
        System.out.println(capacity);


    }

}
