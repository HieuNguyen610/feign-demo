package com.example.feigndemo.files.read;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {

    public static void main(String[] args) {
//        String filePath = "src/main/resources/dummy.txt";
//        readFile(filePath);
        String content = "This is a dummy file.";
        writeFile("src/main/resources/dummy_copy.txt", content);

    }

    public static void readFile(String path) {
        try (FileInputStream inputStreamReader = new FileInputStream(path)) {
            int data;
            while ((data = inputStreamReader.read()) != -1) {
                System.out.print((char)((byte) data));
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    public static void writeFile(String destination, String content) {
        try (FileOutputStream os = new FileOutputStream(destination, true)){
            os.write(content.getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
