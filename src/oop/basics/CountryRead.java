package oop.basics;

import fileworks.DataImport;

import java.util.ArrayList;

public class CountryRead {

    static double ageAverage(ArrayList<Country> countries) {
        double totalSum = 0;

        for (Country country : countries) {
            totalSum += country.expectedAge;
        }

        return totalSum / countries.size();
    }

    static int amountInContinent(ArrayList<Country> countries, String continent) {
        int counter = 0;
        for (Country country : countries) {
            if (country.continent.equals(continent)) {
                counter++;
            }
        }
        return counter;
    }

    static Country mostPopulated(ArrayList<Country> countries){
        Country mostPopulated = countries.get(0);
        for (Country country : countries){
            if (country.population > mostPopulated.population){
                mostPopulated = country;
            }
        }
        return mostPopulated;
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("countries.txt");
//        di.printFile();
        String line;
        String[] attributes;
        Country toRead;

        ArrayList<Country> countries = new ArrayList<>();

        while (di.hasNext()) {
            line = di.readLine();
            attributes = line.split(";");
            toRead = new Country(
                    attributes[0],
                    attributes[1],
                    Integer.parseInt(attributes[2]),
                    Double.parseDouble(attributes[3])
            );
            countries.add(toRead);
        }
        di.finishImport();


        System.out.println("Average life expectancy: " + ageAverage(countries));
        System.out.println("Amount of countries in Europe: " + amountInContinent(countries, "Europe"));
        System.out.println("Most populated country: " + mostPopulated(countries));
    }
}

class Country {
    String name, continent;
    int population;
    double expectedAge;

    public Country(String name, String continent, int population, double expectedAge) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.expectedAge = expectedAge;
    }

    @Override
    public String toString() {
        return name + "(" + continent + ")"
                + " Population: " + population
                + ", life expectancy: " + expectedAge;
    }
}
