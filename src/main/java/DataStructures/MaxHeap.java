package DataStructures;

import java.util.Arrays;

import static Sorting.util.printArray;

public class MaxHeap {

    static int capacity = 7;
    static int size = 0;

    static int[] items = new int[capacity];

    private static int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    private static int getRightIndex (int index) {
        return 2 * index + 2;
    }

    private static int getParentIndex (int index) {
        return (index - 1) / 2;
    }

    private static boolean hasLeftChild(int index) {
        return getLeftIndex(index)< size;
    }

    private static boolean hasRightChild(int index) {
        return getRightIndex(index) < size ;
    }

    private static boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private static int getLeftChild(int index) {
        return items[getLeftIndex(index)];
    }

    private static int getRightChild(int index) {
        return items[getRightIndex(index)];
    }

    private static int getParent(int index) {
        return items[getParentIndex((index))];
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

    public static int peek() {
        if(size == 0) return 0;
        else
            return items[0];
    }

    public static int poll() {
        if(size == 0) {
            return 0;
        }
        else {
            int item = items[0];
            items[0] = items[size-1];
            size--;
            heapifyDown();
            return item;
        }
    }

    public static void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public static void heapifyUp() {
        if (size == 0)
            return;
        else
        {
            int index = size-1;
            while(hasParent(index) && getParent(index) < items[index]) {
                swap(items, getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
    }

    public static void heapifyDown() {
        int index =0;
        while(hasLeftChild(index)) {
            int biggerIndex = getLeftIndex(index);
            if(hasRightChild(index) && getRightChild(index) > getLeftChild(index))
            {
                biggerIndex = getRightIndex(index);
            }

            if(items[index] > items[biggerIndex]) {
                return;
            }
            else {
                swap(items, index, biggerIndex);
                index = biggerIndex;
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
