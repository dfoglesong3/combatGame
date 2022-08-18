package com.genuinedapie.game;

import com.genuinedapie.items.Item;

public class Player {
    private int[] stats = new int[4];
    private Item item;

    public Player(int[] s, Item i) {
        this.item = i;
        this.stats = s;
    }

    public void changeItem(Item item) {
        this.stats[0] -= this.item.getStats()[0];
        this.stats[1] -= this.item.getStats()[1];
        this.stats[2] -= this.item.getStats()[2];

        this.item = item;

        int[] itemStats = item.getStats();
        this.stats[0] += itemStats[0];
        this.stats[1] += itemStats[1];
        this.stats[2] += itemStats[2];

        int currHp = this.stats[2];
        this.stats[3] = currHp;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public void setCurrHp(int currHp) { this.stats[3] = currHp; }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getMaxHp() { return stats[2]; }

    public int getCurrHp() { return stats[3]; }

    public int getSpeed() { return stats[1]; }

    public int getDamage() { return stats[0]; }

    public Item getItem() {
        return item;
    }
}
