package com.example.feigndemo.files.random_access;

import com.example.feigndemo.files.externalizable.Student;
import java.io.RandomAccessFile;

public class RandomAccessExample {

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("src/main/resources/file.txt", "rw")) {
            Student student = new Student("John", "M", 1.4);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
