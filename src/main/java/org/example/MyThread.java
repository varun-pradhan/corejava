package org.example;

    /**
     * TIPS methods -> Start, run, sleep, join, SetPriority, interrupt, yield, setDaemon(True),
     */
public class MyThread extends Thread  {
            public MyThread(String name) {
                super(name);
            }
            @Override
            public void run() {
                for(int i=0; i< 55; i++) {
                        System.out.println(Thread.currentThread().getName()+" -- COUNT - "+i); //+"  -- RUNNING State Priority --> "+Thread.currentThread().getPriority());
                        Thread.yield();  // current give chance to run other threads
                }
            }

/**
 *  DAEMON THREADS - These Thread run in background and jvm does not wait for this thread to terminate
 * as soon Main method thread is done execution it terminates all the threads irrespective of there completion status
 */

            public static void main(String[] args) throws InterruptedException {
                Thread t1 = new org.example.MyThread("First");
                Thread t2 = new org.example.MyThread("Second");
                t1.start();
                t2.start();
//                t1.interrupt();

/*
 Thread low    = new MyThread("Low    Priority Thread");
 Thread medium = new MyThread("Medium Priority Thread");
 Thread high   = new MyThread("High   Priority Thread");
*/
/*
//        System.out.println("Default priority "+ low.getPriority());
        //Set priority to the thread manually
        low.setPriority(MIN_PRIORITY);
        medium.setPriority(NORM_PRIORITY);
        high.setPriority(MAX_PRIORITY);

        low.start();
        high.start();
        medium.start();


        /*
        //  state in a thread
        Thread t1 = new MyThread();
        Thread.State threadState = t1.getState();
        System.out.printf("Currently Thread is in %s state\n", threadState);  //NEW State
        t1.start();
        threadState = t1.getState();
        System.out.printf("Currently Thread is in %s state\n", threadState); //RUNNABLE State
        Thread.sleep(1000);//TIP temporarily puts thread to sleep mode ceases execution
        threadState = t1.getState();
        System.out.printf("After sleep Thread is in %s state\n", threadState);  //TIMED-WAITING state
        t1.join(); //waits for the target thread to die(TERMINATE)
        threadState = t1.getState();
        System.out.printf("Currently Thread is in %s state\n", threadState);  //TERMINATED State
         */
    }
}
