package com.genuinedapie.items;

public class Item {
    protected int[] stats = new int[3];
    protected String name;

    public int[] getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }
}