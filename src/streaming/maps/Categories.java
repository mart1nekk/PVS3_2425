package streaming.maps;

import oop.polymorphism.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Categories {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("data\\movieList.txt"));
        ArrayList<GenreMovie> movies = new ArrayList<>();

        String[] params;
        for (String line : lines) {
            params = line.split(";");
            movies.add(
                    new GenreMovie(params[0],
                            Integer.parseInt(params[1]),
                            params[2],
                            Double.parseDouble(params[3]))
            );
        }

        System.out.println(movies);
        HashMap<String, List<GenreMovie>> genreMap = new HashMap<>();

        for (GenreMovie movie : movies){
            //je tento zanr uz v sade klicu/mape?
            if (genreMap.containsKey(movie.getGenre())){
                genreMap.get(movie.getGenre()).add(movie);
            } else {
                ArrayList<GenreMovie> newGenre = new ArrayList<>();
                newGenre.add(movie);
                genreMap.put(movie.getGenre(), newGenre);
            }
        }

        for (String genre : genreMap.keySet()){
            System.out.println("Genre: " + genre + " - " + genreMap.get(genre));
        }


    }


}

class GenreMovie {
    String name;
    int year;
    String genre;
    double rating;

    public GenreMovie(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " (" + year + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
