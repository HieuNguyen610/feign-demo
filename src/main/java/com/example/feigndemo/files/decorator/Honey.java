package com.example.feigndemo.files.decorator;

public class Honey extends DrinkDecorator{
    public Honey(Drink drink) {
        this.drink = drink;
        this.name = "Honey";
        this.price = 0.25;
    }
}
