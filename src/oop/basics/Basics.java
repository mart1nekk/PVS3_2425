package oop.basics;

import java.awt.*;
import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
        Coordinates coordinates = new Coordinates(4.1, 5.6);
        Rectangle r0 = new Rectangle();
        Rectangle r1 = new Rectangle(new Dimension(450,210));
        Rectangle r2 = new Rectangle(90,180);

        Rectangle[] rcArr = {r0, r1, r2};
        for (int i = 0; i < rcArr.length; i++) {
            System.out.println(rcArr[i].toString());
        }

        System.out.println();


        for(Rectangle r : rcArr){
            System.out.println(r);
        }
    }
}
class Coordinates{
    double x, y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }


}
class Rectangle{
    double height, width;

    final double DEFAULT_HEIGHT = 4;
    final double DEFAULT_WIDTH = 2;
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle(){
        this.width = DEFAULT_WIDTH;
        this.height = DEFAULT_HEIGHT;
    }

    public Rectangle(double width) {
        this.height = DEFAULT_HEIGHT;
        this.width = width;
    }

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
    public Rectangle(double width, int height){
        this.width = width;
        this.height = height;
    }

    public Rectangle(int width, double height){
        this.width = width;
        this.height = height;
    }



    public Rectangle(Dimension d){
        this.height = d.getHeight();
        this.width = d.getWidth();
    }


    double getArea(){
        return width*height;
    }

    @Override
    public String toString() {
        return "H = " + this.height + ", W = " + this.width + ", Area = " + this.getArea();
    }
}
