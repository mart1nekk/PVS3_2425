package oop.references;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Example {
    static void doSomething(int a){
        a += 5;
        System.out.println(a);
    }

    static void doSomething(int[] a){
        a[2] += 5;
        System.out.println(a[2]);
    }


    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);
        doSomething(a);
        System.out.println(a);

        int[] arr = {5, 10, 15};
        System.out.println(arr[2]);
        doSomething(arr);
        System.out.println(arr[2]);

        Arrays.sort(arr);
    }
}
