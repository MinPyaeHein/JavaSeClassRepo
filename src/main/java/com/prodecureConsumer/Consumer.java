package com.prodecureConsumer;

public class Consumer implements Runnable {
    @Override
    public void run() {
        while(true){
            consumeProcess(0);
        }

    }
    public void consumeProcess(int num){
        synchronized (ShareQueue.taskQueue){
            while(ShareQueue.taskQueue.isEmpty()){
                try {
                    System.out.println("I am Waiting for Producing: "+num);
                    ShareQueue.taskQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int consumedNum = (int) ShareQueue.taskQueue.remove(num);
            System.out.println("Consumed: "+consumedNum);
            ShareQueue.taskQueue.notifyAll();
        }
    }
}
