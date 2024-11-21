package oop.collecting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Listing {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
//        LinkedList<Integer> alsoNumbers = new LinkedList<>();

        numbers.add(5);
        System.out.println(numbers);
        ArrayList<Integer> stillNumbers = new ArrayList<>();
        stillNumbers.add(8);
        stillNumbers.add(42);
        stillNumbers.add(50);
        stillNumbers.add(100);
        stillNumbers.add(108,6);
        numbers.addAll(stillNumbers);
        System.out.println(numbers);

        //problematiclke s Integer
        numbers.remove(5);

        //jediny zpusob:
        ArrayList<Integer> yetStillNumbers = new ArrayList<>();
        yetStillNumbers.add(100);
        numbers.removeAll(yetStillNumbers);

        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");

        words.remove("World");
        words.remove(0);

        System.out.println(numbers.get(5));

        System.out.println(numbers.contains(6));

        System.out.println(numbers.indexOf(12));
        System.out.println(numbers.lastIndexOf(12));

//        Integer[] simpleNumbers = numbers.toArray();
//        String[] simpleWrods = (String[]) words.toArray();

        numbers.add(4, 25);
        numbers.set(4, 20); // zmeni, nesoupe
    }

}
