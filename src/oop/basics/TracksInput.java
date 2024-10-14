package oop.basics;

import fileworks.DataExport;
import fileworks.DataImport;

public class TracksInput {
    public static void main(String[] args) {
        DataImport di = new DataImport("Tracks.txt");
        DataExport de = new DataExport("OutputSongs.txt");
        String line;
        String[] params;
        Song s;
        while (di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            s = new Song(
                    params[0],
                    Integer.parseInt(params[1]),
                    Double.parseDouble(params[2]),
                    Integer.parseInt(params[3])
            );
            de.writeLine(s.toString());
            System.out.println(s);
        }

        de.finishExport();
        di.finishImport();
    }
}
class Song{
    String name;
    int yearOfRelease;
    double rating;
    int seconds;

    public Song(String name, int yearOfRelease, double rating, int seconds) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return name + "(" + yearOfRelease + ") " + timeFormat() ;
    }

    String timeFormat(){
        return (seconds/60) + ":" + (seconds%60);
    }
}