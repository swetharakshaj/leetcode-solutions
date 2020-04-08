package Sorting;

import static Sorting.util.printArray;
import static Sorting.util.swap;

public class QuickSort {

    static int iterationId = 0;

    private static void quickSort(int[] arr, int start, int end) {
        System.out.println("Iteration " + iterationId);
        iterationId++;
        if(start < end) {
            int pindex = partition(arr, start, end);
            quickSort(arr, start, pindex-1);
            quickSort(arr, pindex+1, end);
        }

    }

    private static int partition(int[] arr, int start, int end)
    {

        int pivot = arr[end];
        System.out.println("Pivot is " + pivot);
        int partitionIndex= start;

        for(int i = start; i <= end-1; i++) {
            if(arr[i] <= pivot) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, end);
        System.out.println("Partition id = "+ partitionIndex);
        return partitionIndex;
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {9, 2, 11, 2, 7, -2, 0};
        int[] array2 = new int[]{64, 34, 25, 12, 22, 11};

        quickSort(array1, 0, array1.length-1);
        quickSort(array2, 0, array2.length-1);

        printArray(array1);
        printArray(array2);
    }
}
