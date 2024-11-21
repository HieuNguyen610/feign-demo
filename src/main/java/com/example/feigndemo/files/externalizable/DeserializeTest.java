package com.example.feigndemo.files.externalizable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeTest {

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.txt"))) {

            Object object = ois.readObject();
            System.out.println(object);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
