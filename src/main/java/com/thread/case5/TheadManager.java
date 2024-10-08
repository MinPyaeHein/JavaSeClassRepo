package com.thread.case5;

public class TheadManager extends Thread{
    private CounterService counterService;
    public TheadManager(CounterService counterService) {
        this.counterService = counterService;
    }
    @Override
    public void run() {
        this.counterService.counter();

    }
}
