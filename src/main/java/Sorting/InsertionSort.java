package Sorting;

import static Sorting.util.printArray;
import static Sorting.util.swap;

public class InsertionSort {
    private static void insertionSort(int[] arr) {
        int len = arr.length;
        for(int i=0; i< len-1; i++) {
            for (int j=i+1; j>0; j--) {
                if(arr[j]< arr[j-1]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {9, 2, 11, 2, 7, -2, 0};
        int[] array2 = new int[]{64, 34, 25, 12, 22, 11};

        insertionSort(array1);
        insertionSort(array2);

        printArray(array1);
        printArray(array2);
    }
}
