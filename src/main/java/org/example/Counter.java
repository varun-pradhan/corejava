package org.example;

public class Counter {

    private int count = 0;
    /**
     *Synchronized - this keyword ensures that only one thread
     * uses shared resource at a single moment
     *
     * Critical section - Shared resources
     *
     * RaiseCondition - Condition when ambiguity/unpredictability arises
     *
     * Mutual Exclusion - this is what we achieved
     */


    public void increment(){
        synchronized (this) {
            count++;
        }
    }

    public int getCount(){
        return count;
    }

}
