package streaming.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MovieReviews {
    static class Movie{
        private int movieID;
        private String title;
        private String genre;
        private double rating;

        public int getMovieID() {
            return movieID;
        }

        public String getTitle() {
            return title;
        }

        public String getGenre() {
            return genre;
        }

        public double getRating() {
            return rating;
        }

        public Movie(int movieID, String title, String genre) {
            this.movieID = movieID;
            this.title = title;
            this.genre = genre;
            this.rating = Double.NaN;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }
    }

    static class Rating{
        private int movieID;
        private double rating;

        public Rating(int movieID, double rating) {
            this.movieID = movieID;
            this.rating = rating;
        }

        public double getRating() {
            return rating;
        }

        public int getMovieID() {
            return movieID;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movies = Files.lines(Paths.get("data\\reviews\\input.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Movie(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2]
                ))
                .toList();

        System.out.println("Nacteno filmu: " + movies.size());

        List<Rating> ratings = Files.lines(Paths.get("data\\reviews\\ratings.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map( parts -> new Rating(
                        Integer.parseInt(parts[1].trim()),
                        Double.parseDouble(parts[2].trim())
                ))
                .toList();
        System.out.println("Recenzi nacteno: " + ratings.size());

        //namapovat
        //namapovat znovu
        //jednotlive vypocitat prumery
        //vypsat random 10 filmu i s ratingem
        //vypsat prumerny rating pro kategorii
    }
}
