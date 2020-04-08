package Sorting;

import static Sorting.util.printArray;

public class MergeSort {

    static int iterationId = 0;

    private static void mergeSort(int[] arr) {

        System.out.println("Iteration " + iterationId);
        iterationId++;
        int len = arr.length;

        if(len < 2)
            return;
        int mid = len/2;

        // split 2 arrays
        int[] left = new int[mid];
        int[] right  = new int[len-mid];

        for (int i = 0; i <= mid-1; i++) {
            left[i] = arr[i];
        }

        for (int j = mid; j <=len-1; j++) {
            right[j-mid] = arr[j];
        }
        System.out.println("***** Left array ******");
        printArray(left);
        System.out.println("***** Right array ******");
        printArray(right);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);

    }

    private static void merge(int[] left, int[] right, int[] arr) {
        int leftLen = left.length;
        int rightLen = right.length;
        int i = 0, j = 0, k =0;
        while(i < leftLen && j < rightLen){
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < leftLen) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < rightLen) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[] {9, 2, 11, 2, 7, -2, 0};
        int[] array2 = new int[]{64, 34, 25, 12, 22, 11};
        mergeSort(array1);
        mergeSort(array2);
        printArray(array1);
        printArray(array2);

    }
}
