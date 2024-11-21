package com.example.feigndemo.files.serialize;

import com.example.feigndemo.reflection.Person;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeExample {

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/person.txt"))) {
            Person object = (Person) ois.readObject();
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
