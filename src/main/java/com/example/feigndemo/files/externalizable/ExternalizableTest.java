package com.example.feigndemo.files.externalizable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ExternalizableTest {

    public static void main(String[] args) {
        Student student = new Student("John", "M", 1.70);
        File fileObject = new File("student.txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileObject))) {
            oos.writeObject(student);
            System.out.println(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
