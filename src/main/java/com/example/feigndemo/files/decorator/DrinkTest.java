package com.example.feigndemo.files.decorator;

public class DrinkTest {

    public static void main(String[] args) {
        Whiskey w = new Whiskey();
        Honey h = new Honey(w);

        String drinkName = h.getName();
        System.out.println("Drink name: " + drinkName);
        double drinkPrice = h.getPrice();
        System.out.println(drinkPrice);

        Drink myDrink = new Honey(new Whiskey());
        System.out.println(myDrink);

        Drink rumWithHoneyAndSpices = new Spices(new Honey(new Rum()));
        System.out.println(rumWithHoneyAndSpices);

    }
}
