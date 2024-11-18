package com.example.feigndemo.annotation.deprecated;

public class Box {
    public void notDeprecated() {
        System.out.println("Not deprecated");
    }

    @Deprecated(since = "2", forRemoval = false)
    public void deprecatedOrdinary() {
        System.out.println("Deprecated Ordinary");
    }

    @Deprecated(since = "2", forRemoval = true)
    public void deprecatedRemoval() {
        System.out.println("Deprecated Removal");
    }
}
