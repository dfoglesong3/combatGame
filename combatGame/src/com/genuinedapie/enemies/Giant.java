package com.genuinedapie.enemies;

import com.genuinedapie.items.*;

public class Giant extends Enemy {
    public Giant() {
        name = "Giant";
        stats[0] = 4;
        stats[1] = 2;
        stats[2] = 20;
        stats[3] = 20;
        drops[0] = new SharpDagger();
        drops[1] = new SharpSword();
        drops[2] = new SharpAxe();

    }
}