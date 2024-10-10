package com.prodecureConsumer;

public class MainApp {
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();
        Thread thead=new Thread(new Consumer());
        thead.start();

    }
}
