package ru.sennikova.junglesim.entity;

public class Dolphin {
    private int health = 1000;
    private int energy = 1000;
    private final int feed = 10;

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public int getEnergy() {
        return this.energy;
    }

    public int getFeed() {
        return feed;
    }
}
