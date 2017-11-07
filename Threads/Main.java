package MasterClass.Threads;


import static MasterClass.Threads.ThreadColor.ANSI_PURPLE;
import static MasterClass.Threads.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        Thread myThread = new anotherThread();
        myThread.setName("===anotherThread==");
        myThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymus class thread");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class `s implementation of run();");
                try {
                    myThread.join();
                    System.out.println(ANSI_RED + "Another thread terminated, or timed out, so I`m running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn`t wait aflter all. I was intrerrupted");
                }
            }
        });
        myRunnableThread.start();
        //myThread.interrupt();


        System.out.println(ANSI_PURPLE + "Hello again from the MAIN thread.");
    }
}
