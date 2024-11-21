package com.example.feigndemo.files.serialize;

import com.example.feigndemo.reflection.Person;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeExample {

    public static void main(String[] args) {
        // Serialization
        Person person = new Person(1, "John");
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(
            "src/main/resources/person.txt")))) {

            os.writeObject(person);
            os.flush();

            System.out.println(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
