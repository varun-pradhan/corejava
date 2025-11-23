package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class  ReadWriteCounter {

    private int count = 0;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public final Lock readLock = readWriteLock.readLock();
    public final Lock writeLock = readWriteLock.writeLock();

    public int getCount() {
        try{
            readLock.lock();
        return count;
        }finally{
            readLock.unlock();
        }

    }

    public void setCount() {
        try{
            writeLock.lock();
        this.count++;
        }finally{
            writeLock.unlock();
        }
    }
}

public class ReadWriteLockExample{

    public static void main(String[] args) {
        ReadWriteCounter counter = new ReadWriteCounter();

        /*TIPS SAME SAME but Different */
        Runnable readOp = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+ "  read   :"+counter.getCount());
                }
            }
        };
        Runnable writeOp = new Runnable() {
            @Override
            public void run() {
            for(int i=0; i<10; i++){
                System.out.println(Thread.currentThread().getName()+ " written :"+ i);
                counter.setCount();
            }
            }
        };
        Thread readerThread = new Thread(readOp, "Read  1");
        Thread writerThread = new Thread(writeOp, "Write 1");
        Thread readerThread2 = new Thread(readOp, "Read  2");

        try {
            readerThread.start();
            Thread.sleep(5);
            writerThread.start();
            Thread.sleep(5);
            readerThread2.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }
}