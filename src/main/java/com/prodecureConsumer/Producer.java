package com.prodecureConsumer;

public class Producer extends Thread{
   @Override
    public void run() {
     for(int i = 0; i < 10; i++){
         produceProcess(i);
     }
   }
   public void produceProcess(int num){
       synchronized (ShareQueue.taskQueue){
           while(ShareQueue.taskQueue.size()==ShareQueue.taskSize){
               try {
                   System.out.println("I am Waiting for Consuming: "+num);
                   ShareQueue.taskQueue.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           ShareQueue.taskQueue.add(num);
           System.out.println("Produced: "+num);
           ShareQueue.taskQueue.notifyAll();
       }
   }

}
