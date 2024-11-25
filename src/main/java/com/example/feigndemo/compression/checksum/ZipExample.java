package com.example.feigndemo.compression.checksum;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipExample {

    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("src/main/resources/test.zip"));
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/resources/test.txt"));) {

            zos.setLevel(Deflater.BEST_COMPRESSION);
            ZipEntry ze = new ZipEntry("src/main/resources/test.txt");
            zos.putNextEntry(ze);
            // compressed form
            ze.setMethod(ZipEntry.DEFLATED);

            // write compressed data

            byte[] buffer = new byte[1024];
            int count;
            while((count = bis.read(buffer)) != -1) {
                zos.write(buffer, 0, count);
            }
            bis.close();

            zos.closeEntry();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
