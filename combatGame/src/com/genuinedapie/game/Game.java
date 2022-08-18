package com.genuinedapie.game;

import java.util.Random;
import java.util.Scanner;
import com.genuinedapie.enemies.*;
import com.genuinedapie.items.Fists;
import com.genuinedapie.items.Item;

public class Game {
    private Scanner s = new Scanner(System.in);
    private int[] baseStats = {2,1,10,10};
    private Item baseItem = new Fists();
    private Player player = new Player(baseStats, baseItem);

    public void gameLoop() {

        int level = 0;
        System.out.println("Welcome to Combat Game: The Game!");
        System.out.println("Do you have a save? (Y/N)");
        String saveYN = s.nextLine();
        if (saveYN.equals("N")) {
            player.setStats(baseStats);
            player.setItem(baseItem);
        }
        else {
            //load player
        }

        System.out.println("First combat: ");
        while (true) {
            Enemy[] enemyArr = {new Goblin(), new Ogre(), new Giant()};
            Enemy selectedEnemy = enemyArr[level];
            System.out.println("You encountered a " + selectedEnemy.getName() + ".");
            boolean winLose = runCombat(selectedEnemy);

            if (winLose) {
                System.out.print("You won! ");
                if (level != 3) {
                    level += 1;
                }
                Item[] enemyDrops = selectedEnemy.getDrops();
                Item drop = enemyDrops[new Random().nextInt(enemyDrops.length)];

                System.out.println("The " + selectedEnemy.getName() + " dropped a " + drop.getName() + ".");
                System.out.println("Would you like to switch to this weapon? (Y/N)");
                String swapYN = s.nextLine();
                if (swapYN.equals("Y")) {
                    player.changeItem(drop);
                    System.out.println("Swapped weapon to " + drop.getName() + ".");
                    System.out.println("You stats are now: " + player.getDamage() + " damage, " +
                            player.getSpeed() + " speed, and " + player.getMaxHp() + " max hp.");
                    player.setCurrHp(player.getMaxHp());
                }
            }
            else {
                System.out.println("You lost :(");
                player.setCurrHp(player.getMaxHp());
            }

            System.out.println("Fight again? (Y/N)");
            String fightYN = s.nextLine();

            if (fightYN.equals("N")) {
                System.out.println("Save character? (Y/N)");
                String save = s.nextLine();
                if (save.equals("Y")) {
                    //make save
                }

                System.out.println("Thanks for playing!");
            }
        }
    }

    private boolean runCombat(Enemy enemy) { //running one combat

        boolean combatOver = false;
        boolean playerWin = false;
        boolean playerDef = false;
        boolean enemyDef = false;

        while (!combatOver) { //loop until end of combat

            if (player.getSpeed() + new Random().nextInt(20) >
                    enemy.getSpeed() + new Random().nextInt(20)) { //check speed winner
                int pTurn = playerTurn(); //player won speed, going first
                if (pTurn == 1) { //player attacks
                    if (enemyDef) { //check if enemy defended
                        int damage = player.getDamage() / 2;
                        enemy.setCurrHp(enemy.getCurrHp() - damage);
                        enemyDef = false;
                        System.out.println("The " + enemy.getName() + " defended and took "
                                + damage + " damage!");
                        System.out.println("The " + enemy.getName() + " has " + enemy.getCurrHp() +
                                " hp left.");
                    }
                    else { //enemy didn't defend
                        int damage = player.getDamage();
                        enemy.setCurrHp(enemy.getCurrHp() - damage);
                        System.out.println("The " + enemy.getName() + " took " + damage + " damage!");
                        System.out.println("The " + enemy.getName() + " has " + enemy.getCurrHp() +
                                " hp left.");
                    }
                }
                else { //player defends
                    playerDef = true;
                }

                if (enemy.getCurrHp() <= 0) {
                    combatOver = true;
                    playerWin = true;
                }
                else { //enemy turn
                    int eTurn = enemyTurn(enemy.getName());
                    if (eTurn == 1) { //enemy attacks
                        if (playerDef) { //check if player defended
                            int damage = enemy.getDamage() / 2;
                            player.setCurrHp(player.getCurrHp() - damage);
                            playerDef = false;
                            System.out.println("You defended and took " + damage + " damage!");
                            System.out.println("You have " + player.getCurrHp() + " hp left.");
                        }
                        else { //player didn't defend
                            int damage = enemy.getDamage();
                            player.setCurrHp(player.getCurrHp() - damage);
                            System.out.println("You took " + damage + " damage!");
                            System.out.println("You have " + player.getCurrHp() + " hp left.");
                        }
                    }
                    else { //enemy defends
                        enemyDef = true;
                    }

                    if (player.getCurrHp() <= 0) { //check for end of combat
                        combatOver = true;
                        playerWin = false;
                    }
                }
            }
            else {
                int eTurn = enemyTurn(enemy.getName()); //enemy won speed, going first
                if (eTurn == 1) { //enemy attacks
                    if (playerDef) { //check if player defended
                        int damage = enemy.getDamage() / 2;
                        player.setCurrHp(player.getCurrHp() - damage);
                        playerDef = false;
                        System.out.println("You defended and took " + damage + " damage!");
                        System.out.println("You have " + player.getCurrHp() + " hp left.");
                    }
                    else { //player didn't defend
                        int damage = enemy.getDamage();
                        player.setCurrHp(player.getCurrHp() - damage);
                        System.out.println("You took " + damage + " damage!");
                        System.out.println("You have " + player.getCurrHp() + " hp left.");
                    }
                }
                else { //enemy defends
                    enemyDef = true;
                }

                if (player.getCurrHp() <= 0) { //check for end of combat
                    combatOver = true;
                    playerWin = false;
                }
                else {
                    int pTurn = playerTurn(); //player won speed, going first
                    if (pTurn == 1) { //player attacks
                        if (enemyDef) { //check if enemy defended
                            int damage = player.getDamage() / 2;
                            enemy.setCurrHp(enemy.getCurrHp() - damage);
                            enemyDef = false;
                            System.out.println("The " + enemy.getName() + " defended and took "
                                    + damage + " damage!");
                            System.out.println("The " + enemy.getName() + " has " + enemy.getCurrHp() +
                                    " hp left.");
                        }
                        else { //enemy didn't defend
                            int damage = player.getDamage();
                            enemy.setCurrHp(enemy.getCurrHp() - damage);
                            System.out.println("The " + enemy.getName() + " took " + damage + " damage!");
                            System.out.println("The " + enemy.getName() + " has " + enemy.getCurrHp() +
                                    " hp left.");
                        }
                    }
                    else { //player defends
                        playerDef = true;
                    }

                    if (enemy.getCurrHp() <= 0) {
                        combatOver = true;
                        playerWin = true;
                    }
                }
            }
        }

        return playerWin;
    }

    private int playerTurn() {
        System.out.println("It is your turn!");
        System.out.println("Would you like to attack (1) or defend (2)?");
        String action = s.nextLine();
        if (action.equals("1")) {
            System.out.println("You attack!");
            return 1;
        }
        else {
            System.out.println("You defend!");
            return 2;
        }
    }

    private int enemyTurn(String name) {
        System.out.println("It is the " + name + "'s turn!");
        int action = new Random().nextInt(2);
        if (action == 1) {
            System.out.println("The " + name + " attacks!");
            return 1;
        }
        else {
            System.out.println("The " + name + " defends!");
            return 2;
        }
    }
}
