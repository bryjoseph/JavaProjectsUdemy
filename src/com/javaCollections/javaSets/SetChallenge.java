package com.javaCollections.javaSets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetChallenge {

    private static Map<HeavenlyBody.SolarSystemKey, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        /******************Mercury******************/
        // create a new HeavenlyBody (planet)
        HeavenlyBody temp = new Planet("Mercury", 88);
        // add to the Solar System
        solarSystem.put(temp.getSolarSystemKey(), temp);
        // add to the planets
        planets.add(temp);
        /******************Venus******************/
        temp = new Planet("Venus", 225);
        // add to the Solar System
        solarSystem.put(temp.getSolarSystemKey(), temp);
        // add to the planets
        planets.add(temp);

        /******************Earth******************/
        temp = new Planet("Earth", 365);
        // add to the Solar System
        solarSystem.put(temp.getSolarSystemKey(), temp);
        // add to the planets
        planets.add(temp);

        // create a new HeavenlyBody (moon)
        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getSolarSystemKey(), tempMoon);
        temp.addSatellite(tempMoon); // the temp variable is currently Earth

        /******************Mars******************/
        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getSolarSystemKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getSolarSystemKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp variable is currently Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getSolarSystemKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp variable is currently Mars

        /******************Jupiter******************/
        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getSolarSystemKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getSolarSystemKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp variable is currently Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getSolarSystemKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp variable is currently Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getSolarSystemKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp variable is currently Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getSolarSystemKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp variable is currently Jupiter

        /******************Saturn******************/
        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getSolarSystemKey(), temp);
        planets.add(temp);

        /******************Uranus******************/
        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getSolarSystemKey(), temp);
        planets.add(temp);

        /******************Neptune******************/
        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getSolarSystemKey(), temp);
        planets.add(temp);

        /******************Pluto******************/
        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getSolarSystemKey(), temp);
        planets.add(temp);

        System.out.println("Planets: ");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getSolarSystemKey());
        }

        // show a list of moons for a specific planet
        HeavenlyBody jupiter = solarSystem.get(HeavenlyBody.makeSolarSystemKey("Jupiter", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + jupiter.getSolarSystemKey());
        for (HeavenlyBody jupiterMoon : jupiter.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getSolarSystemKey());
        }

        // show all of the moons from all of the planets
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            // addAll is creating a set of all the sets (a Set Union)
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons in the Solar System");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getSolarSystemKey());
        }

        // this will demonstrate overriding equals() and hashCode()
        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto);
        // in this println, pluto should not show up twice because equals and hashCode
        for (HeavenlyBody planet : planets) {
            // old way of printing (NOW) use overridden toString()
            System.out.println(planet);
            // System.out.println(planet.getSolarSystemKey() + " : " + planet.getOrbitalPeriod());
        }

        // adding dwarf planet pluto to test two object can exist with diff bodyTypes
        solarSystem.put(pluto.getSolarSystemKey(), pluto);

        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        // test case #2 e1 == e2 && e2 == e1
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));

        System.out.println();
        System.out.println();
        System.out.println("The Solar System Contains: ");
        for(HeavenlyBody heavenlyBody : solarSystem.values()) {
            // can simplify here because toString is @Override in the class
            System.out.println(heavenlyBody);
        }
    }
}
