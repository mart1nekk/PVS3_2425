package streaming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieLambda {

    public static void main(String[] args) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("data\\movieList.txt"));
            ArrayList<Movie> movies = new ArrayList<>();
            String[] params;
            for (String line : lines) {
                params = line.split(";");
                movies.add(
                        new Movie(params[0],
                                Integer.parseInt(params[1]),
                                params[2],
                                Double.parseDouble(params[3]))
                );
            }

            movies.stream()
                    .filter(movie -> movie.year > 2000)
                    .forEach(System.out::println);

            movies.stream()
                    .sorted(Comparator.comparingDouble(m -> m.rating))
                    .forEach(System.out::println);

           int horrors = (int) movies.stream()
                    .filter(movie -> movie.genre.equalsIgnoreCase("horror"))
                    .count();


           movies.stream()
                   .distinct()
                   .forEach(System.out::println);

           double averageHorror = movies.stream()
                   .filter(movie -> movie.genre.equals("Horror"))
                   .distinct()
                   .mapToDouble(movie -> movie.rating)
                   .average()
                   .orElse(0);
            System.out.println("Average rating for horror: " + averageHorror);


            System.out.println("Horrors count: " + horrors);
            List<Movie> actionUniques = movies.stream()
                    .filter(movie -> movie.genre.equals("Action"))
                    .distinct()
                    .toList();

//            System.out.println(movies);

        } catch (IOException e) {
            System.out.println(":(," + e.getMessage());
        }


    }

}

class Movie {
    String name;
    int year;
    String genre;
    double rating;

    public Movie(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return name + " (" + year + ")";
    }
}