package oop.collecting;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class Queues {


    public static void main(String[] args) {
        LinkingQueue<Integer> numbers = new LinkingQueue<>();
//        numbers.peek();
//        System.err.println("Kouzlo");

        Queue<Player> q = new LinkedList<>();


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
            if (Math.random() <= .16) {
                System.out.println(playerTurn.name + ", bohuzel");
//                players.enqueue(players.dequeue());
            } else {
                System.out.println(playerTurn.name + " prezil");
                players.enqueue(playerTurn);
            }
        }

        System.out.println("Last man standing: " + players.peek().name);
    }

    static void magicPause() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }
}

class QLink<E> {
    E data;
    QLink<E> next;

}

class LinkingQueue<E> {
    QLink<E> start;
    QLink<E> end;

    void enqueue(E data) {
        QLink<E> newLink = new QLink<>();
        newLink.data = data;

        if (start == null) { //fronta je prazdna
            start = newLink;
            end = start;
        } else {
            end.next = newLink;
            end = newLink;
        }
    }

    E peek() {
        if (start == null) {
            throw new RuntimeException("Prazdna fronta");
        }
        return start.data;
    }

    E dequeue() {
        if (start == null) {//neni prazdna
            return null; //idealne chybu
        }
        E tmp = start.data;
        start = start.next;
        return tmp;
    }
}

class ArrayQueue {
    int[] array;
    int first, count;

    public ArrayQueue(int initialCapacity) {
        this.array = new int[initialCapacity];
        first = 0;
        count = 0;
    }

    void enqueue(int toAdd){
        array[(first+count) % array.length] = toAdd;
        count++;
    }

    int dequeue(){
        int toReturn = array[first];
        if (count > 0){
            first = (first + 1) % array.length;
            count--;
            return toReturn;
        } else
            return -1;
    }

    int peek() {
        if (count > 0) {
            return array[first];
        } else return -1;
    }

    void expandArray(){
        int[] newArray = new int[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[(first + i) % array.length];
        }
        array = newArray;
        first = 0;
    }
}