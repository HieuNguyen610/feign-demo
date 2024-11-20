package com.example.feigndemo.functional_interface.method_reference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Item implements Priced{
    private String name = "Unknown";
    private double price = 0.0;

    public static void main(String[] args) {
        Supplier<Item> noArgs = Item::new;
        Function<String, Item> constructorWithName = Item::new;
        BiFunction<String, Double, Item> constructorWithNameAndPrice = Item::new;

        noArgs.get();
        constructorWithName.apply("Apple");
        constructorWithNameAndPrice.apply("Banana", 1.25);
    }

    public Item( ) {
        System.out.println("Constructor Item() called");
    }

    public Item(String name) {
        this.name = name;
        System.out.println("Constructor Item(String) called");
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("Constructor Item(String, double) called");
    }

    public void test() {
        // Item toString
        Supplier<String> s1 = this::toString;
        // Object toString
        Supplier<String> s2 = Item.super::toString;
        // item getPrice
        Supplier<Double> s3 = this::getPrice;
        // Priced getPrice
        Supplier<Double> s4 = Priced.super::getPrice;

        System.out.println("toString: " + s1.get());
        System.out.println("toString: " + s2.get());
        System.out.println("getPrice: " + s3.get());
        System.out.println("getPrice: " + s4.get());
    }
}
