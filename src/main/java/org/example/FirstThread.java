package org.example;

public class FirstThread extends Thread {

    private final Counter counter;

    public FirstThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
           counter.increment();
        }
        }
    }

