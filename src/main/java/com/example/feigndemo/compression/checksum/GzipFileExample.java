package com.example.feigndemo.compression.checksum;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

public class GzipFileExample {

    public static void main(String[] args) {


    }

    public static void zip(String fileName) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("gziptest")))) {



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
