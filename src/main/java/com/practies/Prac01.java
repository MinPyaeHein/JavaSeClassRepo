package com.practies;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;

public class Prac01 {
    public static void main (String[] args) {
       PracGernric prac = new PracGernric();
       prac.displayString("Hello");
       prac.displayInteger(10);
       prac.displayDouble(4.9);

       prac.displayGeneral(10);
       prac.displayGeneral("Hello");
       prac.displayGeneral(4.9);

       prac.displayGeneric(10);
       prac.displayGeneric("Hello");
       prac.displayGeneric(4.9);

       //Case 1:
       StringArrayList array = new StringArrayList();
       array.add("Apple");array.add("Orange");array.add("Banana");array.add("Steel");
       System.out.println(array);

       DoubleArrayList array1 = new DoubleArrayList();
       array1.add(1.2);array1.add(3.4);array1.add(5.6);array1.add(7.8);
       System.out.println(array1);

       IntegerArrayList array2 = new IntegerArrayList();
       array2.add(1);array2.add(3);array2.add(5);array2.add(7);
       System.out.println(array2);

       EmployeeArrayList array3 = new EmployeeArrayList();
       array3.add(new Employee("Apple","USA"));
       array3.add(new Employee("Orange","USA"));
       array3.add(new Employee("Banana","USA"));
       array3.add(new Employee("Steel","USA"));
       System.out.println(array3);

       //Case 2:
        ObjectArrayList arrayObj = new ObjectArrayList();
        arrayObj.add("Apple");arrayObj.add(10);arrayObj.add(4.9);arrayObj.add(new Employee("Apple","USA"));
        System.out.println(arrayObj);

        String apple= (String) arrayObj.get(0);
//        String num= (String) arrayObj.get(1);

        //Case3
        GenericArrayList<Integer> arrayInteger = new GenericArrayList<Integer>();
        arrayInteger.add(1);arrayInteger.add(3);arrayInteger.add(5);arrayInteger.add(7);

        GenericArrayList<Double> arrayDouble = new GenericArrayList<Double>();
        arrayDouble.add(1.2);arrayDouble.add(3.4);arrayDouble.add(5.6);arrayDouble.add(7.8);

        GenericArrayList<String> arrayString = new GenericArrayList<String>();
        arrayString.add("Apple");arrayString.add("Orange");arrayString.add("Banana");arrayString.add("Steel");

        GenericArrayList<Employee> arrayEmployee = new GenericArrayList<Employee>();
        arrayEmployee.add(new Employee("Apple","USA"));
        arrayEmployee.add(new Employee("Orange","USA"));
        arrayEmployee.add(new Employee("Banana","USA"));
        arrayEmployee.add(new Employee("Steel","USA"));

        Employee employee = arrayEmployee.get(0);

       GenericArrayList arrayList=new GenericArrayList();
       arrayList.add(employee);
       arrayList.add(12);

       //Case4
       ArrayList<Employee> employeeList = new ArrayList<Employee>();
       employeeList.add(new Employee("Min Min","Dawei"));

       ArrayList<Employee> employeeList1 = new ArrayList<Employee>();
//       employeeList.

        List<Employee> employeeList2 = new ArrayList<Employee>();
        employeeList2.iterator();

        Vector vector = new Vector();






    }

}
