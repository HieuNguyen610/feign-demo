package com.example.feigndemo.files;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {

    public static void main(String[] args) {
        try (PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream();) {
           // create piped input and output then connect
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create piped input and output then connect using constructor
        try (PipedInputStream pis = new PipedInputStream();
             PipedOutputStream pos = new PipedOutputStream(pis);) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
