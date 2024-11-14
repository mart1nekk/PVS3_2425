package oop.collecting;

import java.util.EmptyStackException;

public class Queues {


    public static void main(String[] args) {
        LinkingQueue<Integer> numbers = new LinkingQueue<>();
//        numbers.peek();
//        System.err.println("Kouzlo");

        LinkingQueue<Player> players = new LinkingQueue<>();
        players.enqueue(new Player("Jarmil"));
        players.enqueue(new Player("Adam"));
        players.enqueue(new Player("Stein"));
        players.enqueue(new Player("Karel"));
        players.enqueue(new Player("Boris"));
        players.enqueue(new Player("Tom"));
        //ve fronte je prave jeden prvek
        while (players.start != players.end) {
            System.out.println("Právě 'hraje': " + players.peek().name);
            magicPause();
            Player playerTurn = players.dequeue();
            if (Math.random() <= .16){
                System.out.println(playerTurn.name + ", bohuzel");
            } else{
                System.out.println(playerTurn.name + " prezil");
                players.enqueue(playerTurn);
            }
        }

        System.out.println("Last man standing: " + players.peek().name);
    }

    static void magicPause(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
class Player{
    String name;

    public Player(String name) {
        this.name = name;
    }
}
class QLink<E>{
    E data;
    QLink<E> next;

}
class LinkingQueue<E>{
    QLink<E> start;
    QLink<E> end;

    void enqueue(E data){
        QLink<E> newLink = new QLink<>();
        newLink.data = data;

        if (start == null) { //fronta je prazdna
            start = newLink;
            end = start;
        }
        else {
            end.next = newLink;
            end = newLink;
        }
    }

    E peek(){
        if (start == null){
            throw new RuntimeException("Prazdna fronta");
        }
        return start.data;
    }

    E dequeue(){
        if (start == null){//neni prazdna
            return null; //idealne chybu
        }
        E tmp = start.data;
        start = start.next;
        return tmp;
    }
}