package com.example.feigndemo.files.exercises;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CountVowel {

    public static void main(String[] args) {
        Map<String, Integer> vowelMap = new HashMap<>();
        vowelMap.put("a", 0);
        vowelMap.put("e", 0);
        vowelMap.put("i", 0);
        vowelMap.put("o", 0);
        vowelMap.put("u", 0);
        System.out.println("Reading file :");
        try (FileReader reader = new FileReader("src/main/resources/vowel.txt")) {
            int data;
            int count = 0;
            while ((data = reader.read()) != -1) {
                count ++;
                String c = String.valueOf((char) data).toLowerCase();
                System.out.println(c);
                if (c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")) {
                    System.out.println("Mapped!");
                    vowelMap.put(c, vowelMap.get(c) + 1);
                }
            }

            System.out.println(vowelMap);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
