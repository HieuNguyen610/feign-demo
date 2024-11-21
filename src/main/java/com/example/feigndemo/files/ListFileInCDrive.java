package com.example.feigndemo.files;

import java.io.File;
import java.io.FileFilter;

public class ListFileInCDrive {

    public static void main(String[] args) {
//        listFilesFromDirectory("C:\\");
//        listFilesFromDirectory("D:\\");

        FileFilter fileOnlyFilter = File::isFile;
        FileFilter dirOnlyFilter = File::isDirectory;
    }

    public static void listFilesFromDirectory(String directoryPath) {
        File dir = new File(directoryPath);

        FileFilter filter = file -> {
          if (file.isFile()) {
              String fileName = file.getName().toLowerCase();
              if(fileName.endsWith(".sys")) {
                  return false;
              }
          }
          return true;
        };
        // filter file with .sys
        File[] files = dir.listFiles(filter);

        for(File file : files) {
            if (file.isFile()) {
                System.out.println(file.getPath() + " (File) ");
            } else if (file.isDirectory()) {
                System.out.println(file.getPath() + " (Directory) ");
            }
        }
    }
}
