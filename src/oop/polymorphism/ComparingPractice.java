package oop.polymorphism;

import fileworks.DataImport;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ComparingPractice {


    static ArrayList<MovieLoad> loadMovies(String filePath){
        ArrayList<MovieLoad> movies = new ArrayList<>();
        DataImport di = new DataImport(filePath);
        String line;
        String[] params;
        while(di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            movies.add(
                    new MovieLoad(params[0],
                            Integer.parseInt(params[1]),
                            Double.parseDouble(params[2]),
                            Integer.parseInt(params[3]))
            );
        }
        di.finishImport();
        return movies;
    }

    static void printByChoice(ArrayList<MovieLoad> movies){
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej cislo, odpovidajici razeni");
        System.out.println("1 - Name");
        System.out.println("2 - Year");
        System.out.println("3 - Rating");
        System.out.println("4 - Duration");

        Comparator<MovieLoad> choice = MovieLoad.BY_NAME;
        switch (sc.nextInt()){
            case 1: choice = MovieLoad.BY_NAME; break;
            case 2: choice = MovieLoad.BY_YEAR; break;
            case 3: choice = MovieLoad.BY_RATING; break;
            case 4: choice = MovieLoad.BY_DURATION; break;
        }
        System.out.println("Reversed? (y/n)");
        choice = sc.nextLine().equals("n") ? choice : choice.reversed();
        movies.sort(choice);

    }

    public static void main(String[] args) {
        ArrayList<MovieLoad> movies = loadMovies("Movies.txt");
    }

}
class MovieLoad {
    String name;
    int year;
    double rating;
    int duration;

    static final Comparator<MovieLoad> BY_NAME = new Comparator<MovieLoad>() {
        @Override
        public int compare(MovieLoad o1, MovieLoad o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    static final Comparator<MovieLoad> BY_RATING = new Comparator<MovieLoad>() {
        @Override
        public int compare(MovieLoad o1, MovieLoad o2) {
            return Double.compare(o1.rating, o2.rating);
        }
    };
    static final Comparator<MovieLoad> BY_YEAR = new Comparator<MovieLoad>() {
        @Override
        public int compare(MovieLoad o1, MovieLoad o2) {
            return Integer.compare(o1.year, o2.year);
        }
    };
    static final Comparator<MovieLoad> BY_DURATION = new Comparator<MovieLoad>() {
        @Override
        public int compare(MovieLoad o1, MovieLoad o2) {
            return Integer.compare(o1.duration, o2.duration);
        }
    };

    public MovieLoad(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }
}