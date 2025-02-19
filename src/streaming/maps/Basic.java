package streaming.maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basic {
    public static void main(String[] args) {
        HashMap<String, String> countries = new HashMap<>();

        countries.put("USA", "Washington DC");
        countries.put("Finland", "Helsinki");
        countries.put("Iceland", "Reykjavik");
        countries.put("Italy", "Rome");
        countries.put("France", "Paris");

        System.out.println(countries.get("Iceland"));

        System.out.println(countries);
//        countries.put("France", "Paris");
        countries.remove("France");
        System.out.println(countries);

        System.out.println(countries.containsKey("England"));
        System.out.println(countries.containsKey("Iceland"));

        for(String country : countries.keySet()){
            System.out.println(country);
            System.out.println(countries.get(country));
        }

        HashMap<String, List<String>> validCountries = new HashMap<>();
        validCountries.put("England", Arrays.stream(new String[]{"London", "Oxford", "Brighton", "York"}).toList());
        validCountries.put("Spain", Arrays.stream(new String[]{"Madrid", "Barcelona", "Seville", "Valencia"}).toList());
        System.out.println(validCountries);
    }
}
