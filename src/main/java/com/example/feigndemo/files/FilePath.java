package com.example.feigndemo.files;

import java.io.File;
import java.io.IOException;

public class FilePath {

    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working directory: " + workingDir);

        String pathName = "dummy.txt";
        printFilePath(pathName);

        pathName = ".." + File.separator + "notes.txt";
        printFilePath(pathName);

    }

    public static void printFilePath(String pathName) {
        File file = new File(pathName);

        System.out.println("File name: " + file.getName());
        System.out.println("File exists: " + file.exists());
        System.out.println("File absolute: " + file.getAbsolutePath());
        try {
            System.out.println("File canonical: " + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        file.deleteOnExit();
    }
}
