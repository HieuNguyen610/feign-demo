package com.example.feigndemo.compression.checksum;

import java.io.UnsupportedEncodingException;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class Adler32Example {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "HELLO";
        byte[] data = str.getBytes("UTF-8");

        Checksum ad = new Adler32();
        ad.update(data);
        long adler32Checksum = ad.getValue();
        System.out.println("Adler32 checksum: " + adler32Checksum);

        Checksum crc32 = new CRC32();
        crc32.update(data);
        long crc32Checksum = crc32.getValue();
        System.out.println("CRC32 checksum: " + crc32Checksum);


    }

    public static int computeAdler32(String input) {
        int a = 1, b = 0;
        for (int i = 0; i < input.length(); i++) {
            a = (a + (input.charAt(i) & 0xff)) % 65521;
            b = (b + a) % 65521;
        }
        return (b << 16) | a;
    }
}
