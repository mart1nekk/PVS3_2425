package streaming.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeriesMapping {

    public static void main(String[] args) throws IOException {
        List<Series> seriesList = Files.lines(Paths.get("data\\series.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(splitLine -> new Series(
                        splitLine[0],
                        splitLine[1]
                ))
                .toList();

        List<Episode> episodeList = Files.lines(Paths.get("data\\episodes.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(parts -> new Episode(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Double.parseDouble(parts[2]),
                        parts[3]
                )).toList();
    }
}

class Series {
    String seriesID, title;
    List<Episode> episodes;

    public Series(String seriesID, String title) {
        this.seriesID = seriesID;
        this.title = title;
        episodes = new ArrayList<>();
    }

    void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }

    public String getSeriesID() {
        return seriesID;
    }

    public String getTitle() {
        return title;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}

class Episode {
    String episodeID;
    int episodeNumber;
    int season;
    double rating;


    public Episode(int season, int episodeNumber, double rating, String episodeID) {
        this.episodeID = episodeID;
        this.episodeNumber = episodeNumber;
        this.season = season;
        this.rating = rating;
    }

    public String getEpisodeID() {
        return episodeID;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public int getSeason() {
        return season;
    }

    public double getRating() {
        return rating;
    }
}

