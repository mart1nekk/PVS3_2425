package oop.inheritance;

import fileworks.DataExport;
import fileworks.DataImport;

import javax.print.Doc;
import java.util.ArrayList;

public class HospitalAnalysis {
    static final int BASE_SALARY = 50000;
    static final int SAlARY_PENALIZATION = 50000;

    static ArrayList<Doctor> loadData(String fileName){
        DataImport di = new DataImport("procedures.txt");
        ArrayList<Doctor> doctors = new ArrayList<>();
        String line;
        String[] data;
        Doctor toLoad = null;
        while (di.hasNext()){
            line = di.readLine();
            data = line.split(",");
            switch (data[1]){
                case "DOC": toLoad = new Doctor(BASE_SALARY, data[0]);
                    break;
                case "SUR": toLoad = new Surgeon(BASE_SALARY, data[0]);
                    break;
                case "CAR": toLoad = new CardiacSurgeon(BASE_SALARY, data[0] );
                    break;
            }
            for (int i = 2; i < data.length; i++) {
                toLoad.listOfProcedures.add(data[i]);
            }
        }

        di.finishImport();
        return doctors;
    }

    static void doProcedures(ArrayList<Doctor> doctors){
        for(Doctor doctor : doctors){
            for (String procedure : doctor.listOfProcedures){
                switch (procedure){
                    case "D":
                        doctor.diagnose();
                        break;
                    case "S":
                        if (doctor instanceof Surgeon)
                            ((Surgeon) doctor).surgery();
                        else
                            doctor.salary -= SAlARY_PENALIZATION;
                        break;
                    case "C":
                        if (doctor instanceof CardiacSurgeon)
                            ((CardiacSurgeon) doctor).cardiacSurgery();
                        else
                            doctor.salary -= SAlARY_PENALIZATION;
                        break;
                }
            }
        }
    }

    static void reportHospital(ArrayList<Doctor> doctors, String fileName){
        DataExport de = new DataExport(fileName);
        for (Doctor doctor : doctors)
            de.writeLine(doctor.toString());
        de.finishExport();
    }

    static Doctor getPoorest(ArrayList<Doctor> doctors){
        Doctor poorest = doctors.get(0);
        for (Doctor doctor : doctors){
            if (poorest.salary > doctor.salary){
                poorest = doctor;
            }
        }
        return poorest;
    }

    static Doctor getMostSuccessful(ArrayList<Doctor> doctors){
        Doctor goodGuy = doctors.get(0);
        for (Doctor doctor : doctors){
            if (goodGuy.salary < doctor.salary){
                goodGuy = doctor;
            }
        }
        return goodGuy;
    }

    public static void main(String[] args) {

    }

}
