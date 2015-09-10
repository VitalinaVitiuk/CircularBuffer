public class CircularBuffer {
    
    private Object[] objects;
    private int size;
    private int getIndex;
    private int putIndex;
    private int counter;

    CircularBuffer(int size) {
        objects = new Object[size];
        this.size = size;
        getIndex = 0;
        putIndex = 0;
        counter = 0;
    }

    public boolean isFull() {
        return (counter == size);
    }

    public boolean isEmpty() {
        return (counter == 0);
    }

    public boolean put(Object o) {
        if (isFull()) {
            return false;
        }
        objects[putIndex] = o;
        putIndex++;
        counter++;
        if (putIndex == size) putIndex = 0;
        return true;
    }

    public Object get() {
        if (getIndex == size) {
            getIndex = 0;
        }
        Object o = objects[getIndex];
        getIndex++;
        counter--;
        return o;
    }
}


