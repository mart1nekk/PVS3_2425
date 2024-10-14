package oop.inheritance;

public class Surgeon extends Doctor{
    int SURGEON_BONUS = 20000;


    public Surgeon(int salary, String name) {
        super(salary, name);
        this.salary += SURGEON_BONUS;
    }

    void surgery(){
        System.out.println("Cutting open...");
        salary += 5000;
    }

    void casualDiagnose(){
        super.diagnose();
    }

    @Override
    void diagnose() {
        System.out.println("Figuring out where to cut...");
        salary += 2000;
    }
}
