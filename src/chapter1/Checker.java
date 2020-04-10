package chapter1;

public class Checker {

    private final Object key1 = new Object();
    private final Object key2 = new Object();

    public void a() {
        synchronized (key1) {
            System.out.println("I'm in thread " + Thread.currentThread().getName());
            b();
        }
    }

    public void b() {
        synchronized (key2) {
            System.out.println("I'm in thread " + Thread.currentThread().getName());
            c();
        }
    }

    public void c() {
        synchronized (key1) {
            System.out.println("I'm in thread " + Thread.currentThread().getName());
        }
    }
}
