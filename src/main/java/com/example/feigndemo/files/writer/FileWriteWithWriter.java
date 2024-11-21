package com.example.feigndemo.files.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileWriteWithWriter {

    public static void main(String[] args) {
        String destFile = "src/main/resources/luci4.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {
            bw.append("And now we reach'd the orchard-plot;");
            bw.newLine();
            bw.append("And, as we climb'd the hill,");
            bw.newLine();
            bw.append("The sinking moon to Lucy's cot");
            bw.newLine();
            bw.append("Came near and nearer still.");

            bw.flush();
            System.out.println("Text was written to " + (new File(destFile)).getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
