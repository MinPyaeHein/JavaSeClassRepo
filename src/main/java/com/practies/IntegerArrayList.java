package com.practies;

import java.util.Arrays;

public class IntegerArrayList {
    private Integer[] arr;
    private int size;
    public IntegerArrayList() {
        this.arr = new Integer[10];
        this.size = 0;
    }
    public void add(Integer str) {
        if(size >= arr.length) {
            Integer[] temp = new Integer[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            this.arr = temp;
        }
        this.arr[size++] = str;
    }
    public Integer get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.arr[index];
    }
    @Override
    public String toString() {
        Integer[] temp = Arrays.copyOf(arr, size);
        return "IntegerArrayList{" +
                "arr=" +Arrays.toString(temp)+
                ", size=" + size +
                '}';
    }
}
