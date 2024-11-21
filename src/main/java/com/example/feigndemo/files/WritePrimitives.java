package com.example.feigndemo.files;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class WritePrimitives {

    public static void main(String[] args) {
        String file = "src/main/resources/primitives.txt";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(765);
            dos.writeDouble(3.14);
            dos.writeBoolean(true);
            dos.writeUTF("Java string");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
