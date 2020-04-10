package chapter1;

/**
 * class that creates a deadlock
 */
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {

        Checker checker = new Checker();

        Runnable r1 = () -> checker.a();
        Runnable r2 = () -> checker.b();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
