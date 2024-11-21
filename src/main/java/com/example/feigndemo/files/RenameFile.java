package com.example.feigndemo.files;

import java.io.File;

public class RenameFile {

    public static void main(String[] args) {
        File oldFile = new File("old.txt");
        System.out.println(oldFile.length());

        File[] roots = File.listRoots();

        System.out.println(roots.length);
        for (File file : roots) {
            System.out.println(file.getPath());
        }
    }
}
