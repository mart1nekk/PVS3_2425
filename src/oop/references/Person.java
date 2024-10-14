package oop.references;

public class Person {
    private String name;
    private int age;

    public static void task1() {
        double d1 = 20;
        double d2 = 40;
        double d3 = 60;
        double[] dd = {d1, d2, d3};
        d2 += 10;
        dd[0] = d2;
        d3 = Double.NaN;
        d1 = d1/2.0;
        for (int i = 0; i < dd.length; i++) {
            System.out.println(dd[i]);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 20);
        Person p2 = new Person("Bob", 30);
        Person p3 = p1;
        p1.name = "Charlie";
        p2.age = 40;
        p3.birthday();
        p3 = p2;
        p2.name = "David";
        p3.birthday();
        p2 = p1;
        p3.birthday();
        p1.birthday();
        p1 = p3;
        p3.name = "Ezra";
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("---");

        task1();

        System.out.println("---");
        
        Sharing.task2();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void birthday() {
        this.age++;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
} class Sharing {
    int value;
    public static void task2() {
        Sharing s1 = new Sharing();
        Sharing s2 = new Sharing();
        Sharing s3 = new Sharing();
        s1.value = 100;
        s2.value = 200;
        Sharing shared = s1;
        shared.value += 50;
        s1 = s2;
        s2 = shared;
        s3.value = s2.value;
        s1.value += 30;
        s2.value += 20;
        s3.value += 10;
        System.out.println(s1.value);
        System.out.println(s2.value);
        System.out.println(s3.value);
    }
}
