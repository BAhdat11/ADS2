public class MyStack<T> {
    private MyList<T> list = new MyArrayList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (list.size() == 0) throw new IllegalStateException("Stack is empty");
        T top = list.getLast();
        list.removeLast();
        return top;
    }

    public T peek() {
        if (list.size() == 0) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
