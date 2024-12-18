package fileworks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BloodBank {


    static void testDonations(int times){
        for (int i = 0; i < times; i++) {
            // TODO: 18.12.2024 Nahodna dvojice se pokusi darovat
        }
    }


    static BloodType parseBlood(String bloodType){
        switch (bloodType){
            case "A+": return BloodType.A_POSITIVE;
            case "B+": return BloodType.B_POSITIVE;
            case "AB+": return BloodType.AB_POSITIVE;
            case "0+": return BloodType.O_POSITIVE;
            case "A-": return BloodType.A_NEGATIVE;
            case "B-": return BloodType.B_NEGATIVE;
            case "AB-": return BloodType.AB_NEGATIVE;
            case "0-": return BloodType.O_NEGATIVE;
            default: return BloodType.AB_POSITIVE;
        }
    }

    ArrayList<BloodDonor> getDonors(String filePath) throws IOException{
        ArrayList<BloodDonor> donors = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        lines.remove(0);//prvni radek jsou nazvy sloupcu
        String[] params;
        BloodDonor donor;
        for (String line : lines){
            params = line.split(",");
            donor = new BloodDonor(
                    params[0],
                    Integer.parseInt(params[1]),
                    params[2],
                    BloodType.valueOf("TBD")
            );
            donors.add(donor);
        }
        return donors;
    }

    public static void main(String[] args) {

    }

}
class BloodDonor{
    String name;
    int age;
    String state;
    BloodType bloodType;

    public BloodDonor(String name, int age, String state, BloodType bloodType) {
        this.name = name;
        this.age = age;
        this.state = state;
        this.bloodType = bloodType;
    }

    boolean donate(BloodDonor from, BloodDonor to){
        return false;
    }
} enum BloodType{
    O_POSITIVE,
    O_NEGATIVE,
    A_POSITIVE,
    A_NEGATIVE,
    B_POSITIVE,
    B_NEGATIVE,
    AB_POSITIVE,
    AB_NEGATIVE
}
