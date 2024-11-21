package com.example.feigndemo.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.springframework.beans.factory.annotation.Value;

public class PrintStreamExercise {

    @Value( value = "${file.path}")
    private static String filePath;

    public static void main(String[] args) {
        String destFile = "src/main/resources/dummy4.txt";
        try (PrintStream ps = new PrintStream(new FileOutputStream(destFile), true)) {
            ps.println("Upon the moon I fix'd my eye,");
            ps.println("All over the wide lea;");
            ps.println("With quickening pace my horse drew nigh");
            ps.print("Those paths so dear to me.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
