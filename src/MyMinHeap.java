public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void add(T item) {
        heap.add(item);
        heapifyUp();
    }

    public T extractMin() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown();
        return min;
    }

    public T peek() {
        if (heap.size() == 0) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void heapifyUp() {
        int index = heap.size() - 1;
        while (index > 0 && heap.get(index).compareTo(heap.get(parent(index))) < 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (leftChild(index) < heap.size()) {
            int smallerChildIndex = leftChild(index);
            if (rightChild(index) < heap.size() &&
                    heap.get(rightChild(index)).compareTo(heap.get(leftChild(index))) < 0) {
                smallerChildIndex = rightChild(index);
            }

            if (heap.get(index).compareTo(heap.get(smallerChildIndex)) <= 0) break;

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }
    private int parent(int i) { return (i - 1) / 2; }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
