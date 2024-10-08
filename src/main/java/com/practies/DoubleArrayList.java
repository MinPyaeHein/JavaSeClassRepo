package com.practies;

import java.util.Arrays;

public class DoubleArrayList {
    private Double[] arr;
    private int size;
    public DoubleArrayList() {
        this.arr = new Double[10];
        this.size = 0;
    }
    public void add(Double str) {
        if(size >= arr.length) {
            Double[] temp = new Double[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            this.arr = temp;
        }
        this.arr[size++] = str;
    }
    public Double get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.arr[index];
    }
    @Override
    public String toString() {
        Double[] temp = Arrays.copyOf(arr, size);
        return "DoubleArrayList{" +
                "arr=" +Arrays.toString(temp)+
                ", size=" + size +
                '}';
    }
}
