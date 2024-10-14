package oop.basics;

public class Game {
    String name;
    int price;
    static int amountCreated = 0;
    static String db_connect = "mysql://";
    public Game(String name, int price) {
        this.name = name;
        this.price = price;
        amountCreated++;
        System.out.println("created: " +
                 toString());
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Game g = new Game("Baldur's gate III", 60);
        System.out.println(Game.amountCreated);
        Game another = new Game("Dark Souls III", 60);
        System.out .println(Game.amountCreated);
        Game yetAnother = new Game("Witcher III", 59);
        System.out.println(Game.amountCreated);


    }
}
