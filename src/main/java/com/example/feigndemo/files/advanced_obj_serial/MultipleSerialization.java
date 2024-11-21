package com.example.feigndemo.files.advanced_obj_serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MultipleSerialization {

    public static void main(String[] args) {
        String fileName = "src/main/resources/animals.txt";
        serialize(fileName);
        System.out.println("--------------------------");
        deserialize(fileName);
    }

    public static void serialize(String fileName) {
        Animal animal = new Animal("cat", 4.0);
        File file = new File(fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeUnshared(animal);
            System.out.println(animal);

            animal.setName("dog");
            animal.setWeight(5.0);
            oos.writeUnshared(animal);
            System.out.println(animal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deserialize(String fileName) {
        File file = new File(fileName);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            Object object = ois.readObject();
            System.out.println(object);

            Object object2 = ois.readObject();
            System.out.println(object2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
