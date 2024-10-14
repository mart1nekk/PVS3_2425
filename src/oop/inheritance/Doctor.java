package oop.inheritance;

import java.util.ArrayList;

public class Doctor {
    int salary;
    String name;
    ArrayList<String> listOfProcedures;

    public Doctor(int salary, String name) {
        this.salary = salary;
        this.name = name;
        listOfProcedures = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }

    public int getSalary() {
        return salary;
    }

    void diagnose(){
        System.out.println("Figuring out what's wrong...");
        salary += 1000;
    }
}
