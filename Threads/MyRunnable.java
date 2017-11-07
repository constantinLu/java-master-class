package MasterClass.Threads;

import static MasterClass.Threads.ThreadColor.ANSI_CYAN;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "Hello from MyRunnables implementation of Run");
    }
}
