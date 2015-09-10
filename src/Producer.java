import java.util.Random;

public class Producer extends Thread {

    private CircularBuffer circularBuffer;
    Random random;

    Producer(CircularBuffer circularBuffer) {
        this.circularBuffer = circularBuffer;
        random = new Random();
    }

    public void put(Object object) {
        synchronized (circularBuffer) {
            if (circularBuffer.isFull()) {
                try {
                    circularBuffer.wait();
                    System.out.println("Producer " + Thread.currentThread().getName() + " waits");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                circularBuffer.put(object);
                System.out.println("Producer " + Thread.currentThread().getName() + " put " + object);
                circularBuffer.notifyAll();
            }
        }
    }


    private Object generateValue() {
        return random.nextInt(40);
    }

    public void run() {
        while (true) {
            put(generateValue());
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
