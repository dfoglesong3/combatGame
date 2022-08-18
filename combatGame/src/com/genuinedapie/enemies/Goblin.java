package com.genuinedapie.enemies;

import com.genuinedapie.items.BluntAxe;
import com.genuinedapie.items.BluntDagger;
import com.genuinedapie.items.BluntSword;

public class Goblin extends Enemy {
    public Goblin() {
        name = "Goblin";
        stats[0] = 1;
        stats[1] = 1;
        stats[2] = 10;
        stats[3] = 10;
        drops[0] = new BluntDagger();
        drops[1] = new BluntSword();
        drops[2] = new BluntAxe();

    }
}