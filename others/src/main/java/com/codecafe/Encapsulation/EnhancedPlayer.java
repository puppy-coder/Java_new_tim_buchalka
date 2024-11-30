package com.codecafe.Encapsulation;

public class EnhancedPlayer {
    private String name;
    private int health;
    private String weapon;

    //Another overloaded constructor, with field "name". set health and wealth with some
    //default values.

    public EnhancedPlayer(String name) {
        this(name, 100, "Sword");
        // health value 100 so that the player starts with good health condition
    }

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        // Make health field values within the range of 1 to 100
        if(health <= 0){
            this.health = 1;
        }else if(health  > 100){
            this.health = 100;
        }else {
            this.health = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        health = health - damage;
        if(health <= 0){
            System.out.println("Player knocked out of game");
        }
    }
    public int healthRemaining(){
        return health;
    }
    public void restoreHealth(int extraHealth){
        health = health + extraHealth;
        if(health > 100){
            System.out.println("Player restored to 100%");
            health = 100;
        }
    }
}
