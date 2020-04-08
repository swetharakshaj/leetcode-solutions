package DataStructures;

import java.util.Arrays;

import static Sorting.util.printArray;

public class MinHeap {
    private static int capacity = 10;
    private static int size = 0;

    static int[] items = new int[capacity];

    // helper functions

    private static int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private static int getrightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private static int getParentIndex (int childIndex) {
        return (childIndex - 1)/2;
    }

    private static boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private static boolean hasRightChild(int index) {
        return getrightChildIndex(index) < size;
    }

    private static boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private static int getLeftchild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private static int getRightChild (int index) {
        return items[getrightChildIndex(index)];
    }

    private static int getParent (int index) {
        return items[getParentIndex(index)];
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void ensureCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity*2);
            capacity*=2;
        }
    }

    // actual methods

    public static int peek() {
        if(size == 0) {
            return 0;
        }
        return items[0];
    }

    public static int poll() {
        int rootElement = peek();
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return rootElement;
    }

    public static void add(int element) {
        ensureCapacity();
        items[size] = element;
        size++;
        heapifyUp();
    }
     public static void heapifyUp() {
        int index = size-1;
        while(hasParent(index) && getParent(index) > items[index]) {
            swap(items, getParentIndex(index), index);
            index = getParentIndex(index);
        }
     }

     public static void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftchild(index)) {
                smallerChildIndex = getrightChildIndex(index);
            }
            if(items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(items, index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }

     }

     public static void main (String[] args) {
        add(9);
        add(2);
        add(11);
        add(2);
        add(7);
        add(-2);
        add(0);

        printArray(items);
     }
}
