package com.practiesCollection;

import java.util.Arrays;

public class GenericArrayList<T> {
    private T[] arr;
    private int size;
    public GenericArrayList() {
        this.arr =(T[]) new Object[10];
        this.size = 0;
    }
    public void add(T str) {
        if(size >= arr.length) {
            T[] temp =(T[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            this.arr = temp;
        }
        this.arr[size++] = str;
    }
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.arr[index];
    }
    @Override
    public String toString() {
        T[] temp = Arrays.copyOf(arr, size);
        return "ObjectArrayList{" +
                "arr=" +Arrays.toString(temp)+
                ", size=" + size +
                '}';
    }
}
