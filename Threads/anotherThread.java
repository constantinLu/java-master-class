package MasterClass.Threads;

import static MasterClass.Threads.ThreadColor.ANSI_BLUE;


public class anotherThread extends Thread {


    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from another thread " + currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.println(" - 1");
            Thread.sleep(1000);
            System.out.println(" - - 2");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + " Another thread woke me up!");
            return;
        }

        System.out.println(ANSI_BLUE + " - - - 3 > Three seconds have passed and I`m awake!");
    }


}
