package org.example;

public class SecondThread implements Runnable{
    @Override
    public void run() {
        for (; ;) {
            System.out.println("Hello \n");
        }

    }
}
