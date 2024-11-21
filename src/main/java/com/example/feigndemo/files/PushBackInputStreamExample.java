package com.example.feigndemo.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushBackInputStreamExample {

    public static void main(String[] args) {
        String srcFile = "src/main/resources/dummy.txt";
        try (PushbackInputStream pis = new PushbackInputStream(new FileInputStream(srcFile))) {
            byte byteData;
            while ((byteData = (byte) pis.read()) != -1) {
                System.out.print((char) byteData);

                pis.unread(byteData);

                byteData = (byte) pis.read();
                System.out.print((char) byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
