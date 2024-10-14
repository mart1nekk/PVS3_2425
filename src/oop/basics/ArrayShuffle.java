package oop.basics;

import java.util.Arrays;

public class ArrayShuffle {

    static void swap(int index1, int index2, int[] array){
        int x = array[index1];
        array[index1] = array[index2];
        array[index2] = x;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6};
        System.out.println(Arrays.toString(arr));
        swap(0,2,arr);
        System.out.println(Arrays.toString(arr));
    }
}