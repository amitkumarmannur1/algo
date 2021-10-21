package practice.Heaps;

public class Heap {

    public int[] heap;
    public int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public boolean isFull() {
        return size == heap.length;
    }


    public int getParent(int index) {

        return (index - 1) / 2;
    }


    public void insert(int value) {
        if (isFull()) {
            //error
        } else {
            heap[size] = value;
        }
        fixHeap(size);
        size++;
    }

    public void fixHeap(int index) {
        int value = heap[index];
        while (index != 0 && value > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = value;
    }

}
