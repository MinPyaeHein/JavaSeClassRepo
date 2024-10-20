package com.practiesCollection;

import java.util.Arrays;

public class EmployeeArrayList {
    private Employee[] arr;
    private int size;
    public EmployeeArrayList() {
        this.arr = new Employee[10];
        this.size = 0;
    }
    public void add(Employee emp) {
        if(size >= arr.length) {
            Employee[] temp = new Employee[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            this.arr = temp;
        }
        this.arr[size++] = emp;
    }
    public Employee get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.arr[index];
    }
    @Override
    public String toString() {
        Employee[] temp = Arrays.copyOf(arr, size);
        return "EmployeeArrayList{" +
                "arr=" +Arrays.toString(temp)+
                ", size=" + size +
                '}';
    }
}
