package basics;

import java.util.Locale;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej double cislo:");
        Locale toUse = Locale.US;
        sc.useLocale(toUse);
        double d = sc.nextDouble();
        System.out.println("Zadals: " + d);
    }
}
