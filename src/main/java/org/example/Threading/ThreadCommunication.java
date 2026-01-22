package org.example.Threading;

class SharedResource {
    private int data; //critical section
    public boolean hasData;  //communication Flag

    public synchronized void produce( int value){
        while(hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        data = value;
        System.out.println("Produced - "+ data);
        hasData = true;
        notify();
    }
     public synchronized  int consume() {
        while(!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasData=false;
         System.out.println("Consumed - "+ data);
        notify();
        return data;
     }
}
class Producer implements Runnable{
    private final SharedResource resource;
    public Producer(SharedResource resource) {   this.resource = resource;     }
    @Override
    public void run() {
        for( int i=0; i<=5; i++){
            resource.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private final SharedResource resource;
    public Consumer(SharedResource resource){  this.resource = resource;}
    @Override
    public void run() {
        for( int i=0; i<=5; i++){
            resource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();
}
    }
