package chapter1;

import sun.jvm.hotspot.debugger.ThreadAccess;

public class FirstRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("I am running in " +  Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);

        thread.setName("new thread");
        thread.start(); //calls the new thread

//        thread.run(); // calls the main thread
    }
}
