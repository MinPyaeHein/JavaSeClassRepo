package com.Day1;

import java.util.HashMap;

public class HashMapExercise {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>(); // <key, value>
        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Cherry");
        hashMap.put(4, "Date");
        hashMap.put(5, "Elderberry");
        hashMap.put(6, "Banana");
        System.out.println("HashMap: " + hashMap);

        String value1=hashMap.get(1);
        System.out.println("HashMap1: " + value1);

        Boolean keyFlag=hashMap.containsKey(7);
        System.out.println("keyFlag: " + keyFlag);

        Boolean valueFlag=hashMap.containsValue("Banana");
        System.out.println("Value Flag: " + valueFlag);

        Student student1 = new Student(1,"Felix",20);
        Student student2 = new Student(2,"Hein ", 30);
        Student student3 = new Student(3,"Dee", 29);
        Student student4 = new Student(4,"Gee", 28);
        Student student5 = new Student(5,"Ri",40);
        Student student6 = new Student(6,"Fen",50);
        Student student7 = new Student(1,"Felix",20);

        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        studentHashMap.put(1, student1);
        studentHashMap.put(2, student2);
        studentHashMap.put(3, student3);
        studentHashMap.put(4, student4);
        studentHashMap.put(5, student5);
        studentHashMap.put(6, student6);
        System.out.println("HashMap: " + studentHashMap);

        Student student = studentHashMap.get(1);
        System.out.println("get Student with key Student: " + student);

        Boolean flag = studentHashMap.containsValue(student);
        System.out.println("Value Flag: " + flag);

        HashMap<Integer, Student> studentClone = (HashMap<Integer, Student>) studentHashMap.clone();
        HashMap<Integer, Student> studentInitialize=   studentClone;
        studentClone.put(7, student7);
        studentHashMap.clear();
        System.out.println("clone Student: " + studentClone);
        System.out.println("HashMap Student: " + studentHashMap);
        System.out.println("studentInitialize: " + studentInitialize);

        studentClone.forEach((key, value) -> System.out.println("key: " + key + " value: " + value));

        for(Student value : studentClone.values()){
            System.out.println("value: " + value);
        }

        for(Integer value : studentClone.keySet()){
            System.out.println("value: " + value);
        }


    }
}
