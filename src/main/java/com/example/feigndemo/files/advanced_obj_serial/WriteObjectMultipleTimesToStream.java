package com.example.feigndemo.files.advanced_obj_serial;

import com.example.feigndemo.files.externalizable.Student;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObjectMultipleTimesToStream {

    public static void main(String[] args) {
        Student student = new Student("John", "M", 6.7);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/student.txt"))) {



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
