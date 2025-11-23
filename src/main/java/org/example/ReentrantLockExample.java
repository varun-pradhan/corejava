package org.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 900;



    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int checkBalance() {
        lock.lock();
        try {
//            System.out.println(Thread.currentThread().getName() + "  Fetching Current Balance");
            return this.getBalance();
        }finally{
//            System.out.println(Thread.currentThread().getName() + "  Balance Fetched ----");
            lock.unlock();
        }
    }

    public void withdrawAmount(int amount) {
        System.out.println(Thread.currentThread().getName() + "  Initialising Withdrawal " + amount);
        try {
//            if (lock.tryLock(6000, TimeUnit.MILLISECONDS)) {
            lock.lockInterruptibly();
                int current_balance = this.checkBalance();
                if (current_balance >= amount) {
                    try {
//                        System.out.println("----- Processing Transaction------");
                        Thread.sleep(40);
                    } catch (Exception e) {
                        System.out.println(Thread.currentThread().getName() + " is Interrupted");
                        Thread.currentThread().interrupt();
                        //            throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }

                    current_balance -= amount;
                    this.setBalance(current_balance);
                    System.out.println(Thread.currentThread().getName() + "  Withdrawal completed remaining balance: " + this.getBalance());
                } else {
                    System.out.println(Thread.currentThread().getName() + "  Insufficient balance");

                }
//            } else {
//                System.out.println(Thread.currentThread().getName() + " said Resource not available");
//            }
        } catch (Exception e) {
//            throw new RuntimeException(e);

        }

    }

    private final Lock lock = new ReentrantLock(true) {
    };
}

public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        BankAccount bankAccount = new BankAccount();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdrawAmount(50);
            }
        };
        Thread t1 = new Thread(runnable, "first_thread ");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t2 = new Thread(runnable, "second_thread");


        t1.start();
        t2.start();
    }
}

