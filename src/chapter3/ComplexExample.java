package chapter3;


public class ComplexExample {
    static int x, y, r11, r21;

    static final Object object = new Object();

    static void first() {
        synchronized (object) {
            y = 1;
        }
        x = 10;
    }

    static void second() {
        synchronized (object) {
            r11 = x;
        }
        r21 = y;
    }
    public static void main(String[] args) throws Exception {
        ComplexExample complexExample = new ComplexExample();

        Runnable r1 = () -> first();
        Runnable r2 = () -> second();


        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t2.start();
        t1.start();

        t1.join();
        t2.join();

        System.out.println(x + " " + y + " " + r11 + " " + r21);
    }
}
