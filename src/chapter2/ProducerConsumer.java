package chapter2;

public class ProducerConsumer {

    private static int[] buffer = new int[10];

    private static int count;

    static class Producer {

        public void produce() {
            while (isFull(buffer)) {

            }

            buffer[count++] = 1;
        }

    }


    static class Consumer {

        public void consume() {
            while (isEmpty(buffer)) {}

            buffer[count--] = 0;
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
                producer.produce();
            }
            System.out.println("Done producing");
        };

        Runnable consume = () -> {
            for (int i = 0; i < 50; i++) {
                consumer.consume();
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
