package com.example.feigndemo.compression.checksum;

import static java.util.zip.Deflater.BEST_COMPRESSION;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionUsingDeflater {

    public static void main(String[] args) throws UnsupportedEncodingException, DataFormatException {
        String input = "Hello world!";
        byte[] uncompressedData = input.getBytes("UTF-8");
// Compress the data
        byte[] compressedData = compress(Arrays.toString(uncompressedData), BEST_COMPRESSION, false);
// Decompress the data
        byte[] decompressedData = decompress(compressedData, false);
        String output = new String(decompressedData, "UTF-8");
// Display the statistics
        System.out.println("Input String: " + input);
        System.out.println("Uncompressed data length: " + uncompressedData.length);
        System.out.println("Compressed data length: " + compressedData.length);
        System.out.println("Decompressed data length: " + decompressedData.length);
        System.out.println("Output String: " + output);
    }

    public static byte[] compress(String input, int compressionLevel, boolean GZIPFormat) throws UnsupportedEncodingException {
        Deflater compressor = new Deflater(BEST_COMPRESSION);

        compressor.setInput(input.getBytes());
        compressor.finish();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] readBuffer = new byte[1024];
        while (!compressor.finished()) {
            int readCount = compressor.deflate(readBuffer);
            if (readCount > 0) {
                baos.write(readBuffer, 0, readCount);
            }
        }
        compressor.end();
        return baos.toByteArray();
    }

    public static byte[] decompress (byte[] input, boolean isGZIPFormat)
        throws DataFormatException {
        Inflater decompressor = new Inflater(isGZIPFormat);

        decompressor.setInput(input);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] readBuffer = new byte[1024];

        while (!decompressor.finished()) {
            int readCount = decompressor.inflate(readBuffer);
            if (readCount > 0) {
                baos.write(readBuffer, 0, readCount);
            }
        }
        decompressor.end();
        return baos.toByteArray();
    }
}
