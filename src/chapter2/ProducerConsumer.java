package chapter2;

public class ProducerConsumer {

    private static Object lock = new Object();

    private static int[] buffer = new int[10];

    private static int count;

    static class Producer {

        public void produce() throws InterruptedException {
            synchronized (lock) {
                while (isFull(buffer)) {
                    lock.wait();
                }

                buffer[count++] = 1;
                lock.notify();
            }
        }

    }


    static class Consumer {

        public void consume() throws InterruptedException {
            synchronized (lock) {
                while (isEmpty(buffer)) {
                    lock.wait();
                }

                buffer[count--] = 0;
                lock.notify();
            }

        }


    }

    static boolean isFull(int[] buffer) {
        if (buffer.length-1 == count) {
            return true;
        }
        return false;
    }

    static boolean isEmpty(int[] buffer) {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produce = () -> {
            for (int i = 0; i < 50; i++) {
                try {
                    producer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done producing");
        };

        Runnable consume = () -> {
            for (int i = 0; i < 50; i++) {
                try {
                    consumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done consuming");
        };

        Thread produceTask = new Thread(produce);
        Thread consumeTask = new Thread(consume);

        produceTask.start();
        consumeTask.start();

        produceTask.join();
        consumeTask.join();

        System.out.println("the final number of items are " + count);

    }

}
