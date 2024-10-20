package com.practiesCollection;

import java.util.Arrays;

public class ObjectArrayList {
    private Object[] arr;
    private int size;
    public ObjectArrayList() {
        this.arr = new Object[10];
        this.size = 0;
    }
    public void add(Object str) {
        if(size >= arr.length) {
            Object[] temp = new Object[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            this.arr = temp;
        }
        this.arr[size++] = str;
    }
    public Object get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.arr[index];
    }
    @Override
    public String toString() {
        Object[] temp = Arrays.copyOf(arr, size);
        return "ObjectArrayList{" +
                "arr=" +Arrays.toString(temp)+
                ", size=" + size +
                '}';
    }
}
