package com.example.feigndemo.inner_classes;

public class Car {
    private final int year;

    public Car(int year) {
        this.year = year;
    }

    public class Tire {
        private final double radius;
        public Tire(double radius) {
            this.radius = radius;
        }

    }
}

class CarTest {

    public static void main(String[] args) {
        Car car = new Car(1900);
        Car.Tire tire = car.new Tire(1);
    }
}
