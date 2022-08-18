package com.genuinedapie.enemies;

import com.genuinedapie.items.*;

public class Enemy {
    protected String name;
    protected int[] stats = new int[4];
    protected Item[] drops = new Item[3];

    public String getName() {
        return name;
    }

    public int[] getStats() {
        return stats;
    }

    public int getCurrHp() {
        return stats[3];
    }

    public int getSpeed() { return stats[1]; }

    public int getDamage() { return stats[0]; }

    public Item[] getDrops() {
        return drops;
    }

    public void setCurrHp(int hp) { this.stats[3] = hp; }
}
