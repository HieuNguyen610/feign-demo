package com.example.feigndemo.files;

import java.io.File;

public class CheckFileExists {

    public static void main(String[] args) {
        File file = new File("check.txt");
        System.out.println(file.exists());
    }
}
