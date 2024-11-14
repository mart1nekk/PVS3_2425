package oop.collecting;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Stacking {
    public static void main(String[] args) {
        LinkStack<Integer> stack = new LinkStack<>();

        stack.push(8);
        stack.push(9);
        stack.push(7);
        stack.pop();
        stack.push(8);
        stack.pop();


        System.out.println(stack.pop());
        stack.push(10);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

}
class ArrayStack{
    private int[] data;
    private int freeIndex;

    void expandArray(){
        int[] newOne = new int[data.length * 2];
//        int[] newOne = new int[data.length + 1];
        System.arraycopy(data, 0, newOne, 0, data.length);
        data = newOne;
    }

    ArrayStack(int capacity){
        data = new int[capacity];
        freeIndex = 0;
    }

    void push(int toAdd){
        if (freeIndex < data.length){
            data[freeIndex] = toAdd;
            freeIndex++;
        } else {
            System.out.println("Out of capacity :(");
        }
    }

    int pop(){
        if (freeIndex > 0){
            int toReturn = data[freeIndex-1];
            freeIndex--;
            return toReturn;
//            return data[freeIndex--];
        }
        return -1;
    }

    int peek(){
        if (freeIndex > 0)
            return data[freeIndex-1];
        return -1;
    }
}
class Link<E>{
    E data;
    Link<E> next;
}
class LinkStack<E>{
    Link<E> top;

    LinkStack(){
        top = null;
    }

    void push(E toAdd){
        //prvni prvek:
        if (top == null){
            top = new Link<>();
            top.data = toAdd;
            top.next = null;//neni nutno psat explicitne
        } //uz tam neco je
        else {
            Link<E> newTop = new Link<>();
            newTop.data = toAdd;
            newTop.next = top; //stary vrchol bude hned za novym
            top = newTop;//prohlasim za novy vrchol
        }
    }

    E pop(){
        if (top == null){
            //idealne hodit chybu
            throw new EmptyStackException();
        }
        E toReturn = top.data;
        top = top.next; //to, co bylo pod topem, je nyni top (nemusi tam byt nic)
        return toReturn;
    }

    E peek(){
        return top.data;
    }

}
