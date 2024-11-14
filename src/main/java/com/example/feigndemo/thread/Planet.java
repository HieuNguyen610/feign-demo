package com.example.feigndemo.thread;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Planet {
    private final Set<String> planets = new TreeSet<>();

    public Planet() {
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Neptune");
    }

    public boolean isPlanet(String planetName) {
        return planets.contains(planetName);
    }

    public void addPlanet(String planetName) {
        planets.add(planetName);
    }

    public static void main(String[] args) {
        Planet planet  = new Planet();
        System.out.println(planet.isPlanet("Earth"));
        planet.addPlanet("Moon");
        System.out.println(planet.isPlanet("Moon"));
    }
}
