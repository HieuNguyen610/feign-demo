package com.example.feigndemo.compression.checksum;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.Deflater;

public class JarUtility {

    public static void main(String[] args) {

    }

    public static void createJar(String jarFileName, String[] jarEntries, Manifest manifest) {

        String currentDir = System.getProperty("user.dir");
        try (JarOutputStream jos = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(jarFileName)), manifest)) {

            jos.setLevel(Deflater.BEST_COMPRESSION);
            for (String jarEntry : jarEntries) {
                File entryFile = new File(jarEntry);
                if (!entryFile.exists()) {
                    System.out.println("File does not exist: " + entryFile.getAbsolutePath());
                    System.out.println("Abort processing...");
                    System.exit(1);
                }

                JarEntry je = new JarEntry(jarEntry);
                jos.putNextEntry(je);
                addEntryContent(jos, jarEntry);
                jos.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addEntryContent(JarOutputStream jos, String entryFileName) {
        try (BufferedOutputStream bos = new BufferedOutputStream(jos)) {
            byte[] buffer = new byte[1024];
            int count;
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(entryFileName))) {
                while ((count = bis.read(buffer))!= -1) {
                    bos.write(buffer, 0, count);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
