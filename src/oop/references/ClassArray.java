package oop.references;

public class ClassArray {
    public static void main(String[] args) {
        Coordinates c = new Coordinates(4.1, 5.8);
        System.out.println(c.x);
        System.out.println(c.y);
        System.out.println(c);

        Coordinates[] coords = new Coordinates[5];

        coords[0] = new Coordinates(4.8, 2.5);
        coords[1] = new Coordinates(4.8, 2.5);
        coords[2] = new Coordinates(4.8, 2.5);
        coords[3] = new Coordinates(4.8, 2.5);

        for (int i = 0; i < coords.length; i++) {
            System.out.println(coords[i]);
        }

        Coordinates[] coordinates = {
                new Coordinates(48.4,12.5),
                c,
                new Coordinates(400_000_000_000_005.54, .9)
        };

        for (int i = 0; i < coordinates.length; i++) {
            System.out.println(coordinates[i]);
        }

//        Coordinates cord = coordinates[0];

//        for(Coordinates cord : coordinates){
//            System.out.println(cord);
//        }
    }

}

class Coordinates {
    double x, y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ";" + y + "]";
    }
}
