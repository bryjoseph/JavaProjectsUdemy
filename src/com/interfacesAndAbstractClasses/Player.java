package com.interfacesAndAbstractClasses;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISavable {

    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;
    private ArrayList<Integer> scoreHistory;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
        this.scoreHistory = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public ArrayList<Integer> getScoreHistory() {
        return scoreHistory;
    }

    public void setScoreHistory(ArrayList<Integer> scoreHistory) {
        this.scoreHistory = scoreHistory;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + this.strength);
        values.add(3, this.weapon);

        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if((savedValues != null) && (savedValues.size() > 0)) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }
    }

//    @Override
//    public void saveScore(int playerScore) {
//        if(playerScore > 0) {
//            this.scoreHistory.add(playerScore);
//        } else {
//            System.out.println("Valid score not saved");
//        }
//    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
