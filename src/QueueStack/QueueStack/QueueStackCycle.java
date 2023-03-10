package QueueStack.QueueStack;

public class QueueStackCycle implements QueueStackInterface{
    private static final int CAPACITY = 100;
    private int Capacity;
    private Object S[];
    private int first = 0;
    private int last = 0;

    public QueueStackCycle() {
        this(CAPACITY);
    }

    public QueueStackCycle(int cap) {
        Capacity = cap + 1;
        S = new Object[Capacity];
    }

    @Override
    public int size() {
        return (Capacity+last-first)%Capacity;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public boolean isFull() {
        return size()==(Capacity-1);
    }

    @Override
    public Object front() throws QueueStackEmptyException {
        if (isEmpty())
            throw new QueueStackEmptyException("Queue is Empty");
        return S[first];
    }

    @Override
    public void enqueue(Object item) throws QueueStackFullException {
        if (isFull())
            throw new QueueStackEmptyException("Queue Overflow");

        S[last] = item;
        last = (last+1)%Capacity;
    }

    @Override
    public Object dequeue() throws QueueStackEmptyException {
        Object item;

        if ( isEmpty())
            throw new QueueStackEmptyException("Queue is Empty");

        item = S[first];
        S[first] = null;
        first = (first+1)%Capacity;

        return item;
    }
}
