package com.example.feigndemo.files.decorator;

public class Spices extends DrinkDecorator{
    public Spices(Drink drink) {
        this.drink = drink;
        this.name = "Spices";
        this.price = 0.1;
    }
}
