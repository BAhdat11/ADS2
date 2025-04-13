public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArr = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArr, 0, size);
            elements = newArr;
        }
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        elements[size] = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }

    public void addFirst(T item) { add(0, item); }

    public void addLast(T item) { add(item); }

    public T getFirst() { return get(0); }

    public T getLast() { return get(size - 1); }

    public void removeFirst() { remove(0); }

    public void removeLast() { remove(size - 1); }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++)
            if (elements[i].equals(obj)) return i;
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = size - 1; i >= 0; i--)
            if (elements[i].equals(obj)) return i;
        return -1;
    }

    public boolean exists(Object obj) {
        return indexOf(obj) != -1;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        System.arraycopy(elements, 0, arr, 0, size);
        return arr;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) elements[j];
                if (a.compareTo((T) elements[j + 1]) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            int cursor = 0;

            public boolean hasNext() {
                return cursor < size;
            }

            public T next() {
                return (T) elements[cursor++];
            }
        };
    }
}
