package com.example.feigndemo.string_example;

public class TrimAndStrip {

    static char whiteSpaceUnicode = '\u2000';

    public static void main(String[] args) {
        String textNeedTrim = whiteSpaceUnicode + "hello" + whiteSpaceUnicode + "world";
        System.out.println(textNeedTrim);
        System.out.println(textNeedTrim.trim());
        System.out.println(textNeedTrim.strip());
    }
}
