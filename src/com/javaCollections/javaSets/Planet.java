package com.javaCollections.javaSets;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        // for a planet, it makes sense to check that the HeavenlyBody is in fact a MOON bodyType
        if(moon.getSolarSystemKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
