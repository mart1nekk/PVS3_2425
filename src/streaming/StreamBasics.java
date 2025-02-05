package streaming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class StreamBasics {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int)(Math.random() * 100));
        }

        System.out.println(numbers);

        int size = (int) numbers.stream()
                .count();
        System.out.println("Size alternativne: " + size);

        int size2 = (int) numbers.stream()
                .distinct()
                .count();
        System.out.println("Unikatnich: " + size2);

        int upper = (int) numbers.stream()
                .filter(num -> num > 50)
                .distinct()
                .count();

        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        //alternativni
        numbers.stream()
                .sorted(Integer::compare)
                .forEach(System.out::println);

//        String[] array = {"Bořek","Jarmil", "Vysavač", "Řehoř", "Výjimka" };
//        Stream.of(array)
//                .sorted(Comparator.comparingInt(str -> (char) (str.length() - 1)))
//                .forEach(System.out::println);

        double average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }
}
