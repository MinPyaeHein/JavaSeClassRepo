package com.exceptionHlanding;

public class Ex1 {
    public static void main(String[] args) {
//        int[] numbers=new int[20];
//        numbers[0]=1;
//        numbers[1]=2;
//        System.out.println("Enter number: ");
//        try {
//            int num=Integer.parseInt(System.console().readLine());
//            System.out.println("Get number with index::"+numbers[num]);
//        }catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Index out of bounds");
//            System.out.println("Exception message: "+e.getMessage());
//        }catch (NumberFormatException e) {
//            System.out.println("Invalid input. Please enter a number.");
//            System.out.println("Exception message: "+e.getMessage());
//        }finally{
//            System.out.println("Thanks You!!");
//        }
//        int num=Integer.parseInt(System.console().readLine());
//        System.out.println("Get number with index::"+numbers[num]);
//        System.out.println("Program finished");
//        System.out.println("Enter Yout Name");
//        String name=System.console().readLine();
//        System.out.println("Hello "+name);
//        System.out.println("Length of Name: "+name.length());

//        Ex2 ex2=new Ex2();
//        System.out.println("Enter Number to get fruit:");
//        try{
//            int num=Integer.parseInt(System.console().readLine());
//            ex2.getNameFromArray(num);
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("Exception message: "+e.getMessage());
//        }

//        System.out.println("Enter Amount that you want to deposite::");
//        double amount=Double.parseDouble(System.console().readLine());
//        try{
//            if(amount<0){
//                throw new BalanceException("Invalid deposit amount. Please enter a positive value.");
//            }
//        }catch(BalanceException e){
//            System.out.println(e.getMessage());
//        }

        Ex2 ex2=new Ex2();
        ex2.getName();

    }
}
