public class MyQueue<T> {
    private MyList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (list.size() == 0) throw new IllegalStateException("Queue is empty");
        T front = list.getFirst();
        list.removeFirst();
        return front;
    }

    public T peek() {
        if (list.size() == 0) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
