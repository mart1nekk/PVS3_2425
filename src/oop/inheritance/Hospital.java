package oop.inheritance;

import javax.print.Doc;

public class Hospital {

    public static void main(String[] args) {
        Doctor carl = new Doctor(50000,"Carl");
        System.out.println(carl.name + ": " + carl.getSalary());
        carl.diagnose();
        carl.diagnose();
        System.out.println(carl.name + ": " + carl.getSalary());
        Surgeon joseph = new Surgeon(50000, "Joseph");
        System.out.println(joseph.name + ": " + joseph.getSalary());
        joseph.surgery();
        joseph.diagnose();
        System.out.println(joseph.name + ": " + joseph.getSalary());

        CardiacSurgeon frenchie = new CardiacSurgeon(50000, "Frenchie");
        System.out.println(frenchie.name + ": " + frenchie.getSalary());
        frenchie.cardiacSurgery();
        frenchie.surgery();
        frenchie.diagnose();
        System.out.println(frenchie.name + ": " + frenchie.getSalary());


        Doctor jarmil = new Surgeon(50000,"Jarmil");
        System.out.println(jarmil.getSalary());

        //varianta 1, pretypovat a hodit do promenne.
//        Surgeon temp = (Surgeon) jarmil;

        //varianta 2, rovnou volat na pretypovanou promennou
//        ((Surgeon) jarmil).surgery();

        System.out.println("___");
        Doctor[] doctors = {carl, joseph, frenchie, jarmil};
        //vsichni zkusi operaci:
        for(Doctor doctor : doctors){
            //pokus se o operaci
            System.out.println(doctor.name + " attempting surgery...");
            if (doctor instanceof Surgeon){
                ((Surgeon)doctor).surgery();
            } else {
                System.out.println(doctor.name + " is not qualified for surgeries");
            }
        }

    }
}
