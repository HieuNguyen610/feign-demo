package com.example.feigndemo.files.exercises;

import java.io.File;

public class FileExercises {

    public static void main(String[] args) {
        String directoryPath = "D:\\java-project\\feign-demo";

        if (isExistentDirectory(directoryPath)) {
            System.out.println("Directory exists and is a directory.");
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }

    public static boolean isExistentDirectory(String pathName) {
        File file = new File(pathName);
        return file.exists() && file.isDirectory();
    }
}
