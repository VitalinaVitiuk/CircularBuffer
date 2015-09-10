
public class App {
    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer(10);
        Consumer consumer1 = new Consumer(circularBuffer);
        Consumer consumer2 = new Consumer(circularBuffer);
        Consumer consumer3 = new Consumer(circularBuffer);

        Producer producer1 = new Producer(circularBuffer);
        Producer producer2 = new Producer(circularBuffer);

        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer1.start();
        producer2.start();
    }
}
