package com.practies;

import java.util.Arrays;

public class StringArrayList {
    private String[] arr;
    private int size;
    public StringArrayList() {
        this.arr = new String[10];
        this.size = 0;
    }
    public void add(String str) {
        if(size >= arr.length) {
            String[] temp = new String[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            this.arr = temp;
        }
        this.arr[size++] = str;
    }
    public String get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.arr[index];
    }

    @Override
    public String toString() {
       String[] temp = Arrays.copyOf(arr, size);
        return "StringArrayList{" +
                "arr=" +Arrays.toString(temp)+
                ", size=" + size +
                '}';
    }
}
