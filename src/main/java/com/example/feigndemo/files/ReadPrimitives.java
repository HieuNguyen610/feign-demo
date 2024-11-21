package com.example.feigndemo.files;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadPrimitives {

    public static void main(String[] args) {
        String srcFile = "src/main/resources/primitives.txt";
        try (DataInputStream dis = new DataInputStream(new FileInputStream(srcFile))) {
            String msg = dis.readUTF();
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean booleanValue = dis.readBoolean();

            System.out.println(intValue);
            System.out.println(doubleValue);
            System.out.println(booleanValue);
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
