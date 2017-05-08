package com.aequilibrium.Transformer;

public class Autobot extends Transformer {
    public Autobot(String name, char type, int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower, int skill) {
        super(name, strength, intelligence, speed, endurance, rank, courage, firepower, skill);
    }

    @Override
    public int compare(Transformer o1, Transformer o2) {
        return 0;
    }
}
