package oop.inheritance;

import java.util.ArrayList;

public class Cuboid extends Rectangle {
    double depth;

    public Cuboid(double width, double height, double depth) {
        super(width, height);
        this.depth = depth;
    }

    double getVolume() {
        return super.getArea() * depth;
    }


    @Override
    public double getArea() {
        return 2 * ((height * width) + (height * depth) + (depth * width));
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 6);
        System.out.println(r.getArea());

        Cuboid c = new Cuboid(5, 6, 3);
        System.out.println(c.getArea());

        Rectangle weird = new Cuboid(4,1,3);

        if (weird instanceof Cuboid){
            //pretypovani, weirdCuboid je ted kvadr
            Cuboid weirdCuboid = (Cuboid) weird;
            //rovnou pouzivam veci kvadru
            ((Cuboid)weird).getArea();
        }

//        Nebude fungovat
//        Cuboid another = new Rectangle(4,5);

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Cuboid(5,3,6));
        rectangles.add(new Cuboid(5,3,2));
        rectangles.add(new Rectangle(5,3));

        for (Rectangle rectangle : rectangles){
            System.out.println(((Cuboid)rectangle).getVolume());
        }
    }
}
