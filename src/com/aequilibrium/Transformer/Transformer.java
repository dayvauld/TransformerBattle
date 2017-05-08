package com.aequilibrium.Transformer;

import java.util.Comparator;

abstract public class Transformer implements Comparable<Transformer>, Comparator<Transformer> {
    String name;
    boolean alive;
    Attribute strength;
    Attribute intelligence;
    Attribute speed;
    Attribute endurance;
    Attribute rank;
    Attribute courage;
    Attribute firepower;
    Attribute skill;

    Transformer(String name, int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower, int skill) {
        this.strength = new Attribute(strength);
        this.intelligence = new Attribute(intelligence);
        this.speed = new Attribute(speed);
        this.endurance = new Attribute(endurance);
        this.rank = new Attribute(rank);
        this.courage = new Attribute(courage);
        this.firepower = new Attribute(firepower);
        this.skill = new Attribute(skill);

        this.name = name;
        this.alive = true;
    }

    Transformer(String name, int[] stats) {
        this.name = name;
    }

    public int getOverallRating() {
        return strength.getValue() + intelligence.getValue() + speed.getValue() + endurance.getValue() + firepower.getValue();
    }

    public String getName() {
        return this.name;
    }

    public void killTransformer() {
        this.alive = false;
    }

    public boolean isAlive(){
        return this.alive;
    }
    @Override
    public int compareTo( final Transformer o) {
        return Integer.compare( o.getOverallRating(), this.getOverallRating());
    }


    public Attribute getCourage() {
        return courage;
    }

    public Attribute getStrength() {
        return strength;
    }

    public Attribute getSkill() {
        return skill;
    }
}
