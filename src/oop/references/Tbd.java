package oop.references;

public class Tbd {

    public static void main(String[] args) {
        countDown(1);
    }

    static int countDown(int n){
        System.out.println(n);
        if (n < Integer.MAX_VALUE){
            return countDown(n+1);
        }
        return n;
    }
}
