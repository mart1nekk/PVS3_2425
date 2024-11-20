package exams;

import java.util.LinkedList;
import java.util.Queue;

class Character {
    String name;
    int health;
    int attack;

    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    /**
     * Postava se pokusi zautocit na jinou
     *
     * @param opponent postava, na kterou je utoceno
     */
    public void attack(Character opponent) {
        System.out.println(name + " attacks " + opponent.name + " for " + attack + " damage!");
        opponent.health -= attack;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " (HP: " + health + ", Attack: " + attack + ")";
    }
}

public class RPGQueue {
    public static void main(String[] args) {
        Queue<Character> team1 = new LinkedList<>();
        Queue<Character> team2 = new LinkedList<>();

        team1.add(new Character("Warrior", 50, 10));
        team1.add(new Character("Mage", 30, 15));
        team1.add(new Character("Rogue", 40, 12));

        team2.add(new Character("Goofy Bear", 55, 8));
        team2.add(new Character("Spider", 15, 14));
        team2.add(new Character("AnotherSpider", 15, 14));
        team2.add(new Character("Wolf", 45, 10));

        System.out.println("Starting Battle!");
        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);

        while (!team1.isEmpty() && !team2.isEmpty()) {
            Character attacker1 = team1.peek();
            Character attacker2 = team2.peek();

            if (attacker1.isAlive()) //zvlastni pripad - tady by teoreticky nemel nastat
             attacker1.attack(attacker2);

            if (!attacker2.isAlive()) {
                System.out.println(attacker2.name + " is defeated!");
                team2.poll();
            }

            if (team2.isEmpty()) break;

            if (attacker2.isAlive()) //zvlastni pripad
                attacker2.attack(attacker1);

            if (!attacker1.isAlive()) {
                System.out.println(attacker1.name + " is defeated!");
                team1.poll();
            }

            System.out.println("Team 1: " + team1);
            System.out.println("Team 2: " + team2);
            System.out.println("-----------------------------------");
        }

        if (team1.isEmpty()) {
            System.out.println("Team 2 wins the battle!");
        } else {
            System.out.println("Team 1 wins the battle!");
        }
    }
}
