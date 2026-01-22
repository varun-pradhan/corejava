package org.example;

public class GenericArrayList<T> {
    private int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;  // Index of last element in the array

    public GenericArrayList(int DEFAULT_SIZE) {
//        this.DEFAULT_SIZE = DEFAULT_SIZE;
         this.data = new Object[DEFAULT_SIZE];
    }
}
