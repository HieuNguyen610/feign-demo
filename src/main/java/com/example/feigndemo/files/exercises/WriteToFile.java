package com.example.feigndemo.files.exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteToFile {

    public static void main(String[] args) {
        String filePath = "src/main/resources/test.txt";
        try (FileOutputStream fis = new FileOutputStream(filePath)) {

            String text = "Hello";
            byte[] bytes = text.getBytes();
            fis.write(bytes);
            System.out.println("File written successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println("Reading the file " + filePath);
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
