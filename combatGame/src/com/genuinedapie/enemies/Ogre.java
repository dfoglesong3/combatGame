package com.genuinedapie.enemies;

import com.genuinedapie.items.Axe;
import com.genuinedapie.items.Dagger;
import com.genuinedapie.items.Sword;

public class Ogre extends Enemy {
    public Ogre() {
        name = "Ogre";
        stats[0] = 2;
        stats[1] = 1;
        stats[2] = 15;
        stats[3] = 15;
        drops[0] = new Dagger();
        drops[1] = new Sword();
        drops[2] = new Axe();

    }
}