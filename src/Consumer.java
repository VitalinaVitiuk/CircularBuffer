
public class Consumer extends Thread {

    private CircularBuffer circularBuffer;

    Consumer(CircularBuffer circularBuffer) {
        this.circularBuffer = circularBuffer;
    }

    public void get() {
        synchronized (circularBuffer) {
            if (circularBuffer.isEmpty()) {
                try {
                    circularBuffer.wait();
                    System.out.println("Consumer " + Thread.currentThread().getName() + " waits");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consumer " + Thread.currentThread().getName() + "took  " + circularBuffer.get());
            circularBuffer.notifyAll();
        }
    }

    public void run() {
        while (true) {
            get();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



