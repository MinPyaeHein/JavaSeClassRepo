package com.DatePractice;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static void main(String[] args) {
    Date date = new Date();
    System.out.println(date);
    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = dateFormat1.format(date);
    System.out.println("Date Formate 1 :: "+formattedDate);

    SimpleDateFormat dateFormat2 = new SimpleDateFormat("mm/dd/yyyy");
    String formattedDate2 = dateFormat2.format(date);
    System.out.println("Date Formate 2 :: "+formattedDate2);

    //find date difference
        Date date1 = new Date();
        try {
            Date date2 = dateFormat1.parse("2024-11-01 12:00:00");
            long diff = date2.getTime() - date1.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            System.out.println("Date difference in days :: "+diffDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
