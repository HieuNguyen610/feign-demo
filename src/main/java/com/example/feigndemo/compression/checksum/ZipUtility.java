package com.example.feigndemo.compression.checksum;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtility {

    public static void main(String[] args) {
        String[] zipEntries = {"src/main/resources/test.txt"};
        zip("test1.zip", zipEntries);
        unzip("test1.zip", "zip");
    }

    public static void unzip(String zipFileName, String unzipDirectory) {
        String currentDir = System.getProperty("user.dir");
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                extractEntryContent(zis, entry, unzipDirectory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extractEntryContent(ZipInputStream zis, ZipEntry entry, String unzipDirectory)
        throws IOException {
        String entryFileName = entry.getName();
        String entryPath = unzipDirectory + File.separator + entryFileName;

        createFile(entryPath);

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(entryPath))) {
            byte[] buffer = new byte[1024];
            int count;
            while ((count = zis.read(buffer))!= -1) {
                bos.write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createFile(String filePath) throws IOException {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        file.createNewFile();
    }

    public static void zip(String zipFileName, String[] zipEntries) {
        String currentDir = System.getProperty("user.dir");

        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFileName)))) {
            zos.setLevel(Deflater.BEST_COMPRESSION);
            for (String zipEntry : zipEntries) {
                File entryFile = new File(zipEntry);
                if (!entryFile.exists()) {
                    System.out.println("The entry file " + entryFile.getAbsolutePath() + " does not exists");
                    System.out.println("Aborted processing");
                    System.exit(1);
                }

                ZipEntry ze = new ZipEntry(zipEntry);

                zos.putNextEntry(ze);
                addEntryContent(zos, zipEntry);
                zos.closeEntry();
            }

            System.out.println("Zipped the files to : " + currentDir + File.separator + zipFileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addEntryContent(ZipOutputStream zos, String entryFileName) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(entryFileName))) {
            byte[] buffer = new byte[1024];
            int count;
            while ((count = bis.read(buffer))!= -1) {
                zos.write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
