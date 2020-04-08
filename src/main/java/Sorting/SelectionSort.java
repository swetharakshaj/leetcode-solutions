package Sorting;

import static Sorting.util.printArray;
import static Sorting.util.swap;

public class SelectionSort {

    private static void selectionSort(int[] arr) {
        int len  = arr.length;
        int minIndex;
        for(int i=0; i < len-1; i++) {
            minIndex = i;
            for(int j=i+1; j < len ; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {9, 2, 11, 2, 7, -2, 0};
        int[] array2 = new int[]{64, 34, 25, 12, 22, 11};
        selectionSort(array1);
        selectionSort(array2);
        printArray(array1);
        printArray(array2);

    }
}
