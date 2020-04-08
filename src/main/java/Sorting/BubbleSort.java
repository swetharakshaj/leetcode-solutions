package Sorting;

import static Sorting.util.printArray;
import static Sorting.util.swap;

public class BubbleSort
{

    private static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        int count = 0;
        int lastSortedEle = arr.length-1;
        while(!isSorted) {
            isSorted = true;
            for(int i=0; i < lastSortedEle; i++) {
                if(arr[i] > arr[i+1])
                {
                    swap(arr, i, i+1);
                    count++;
                    isSorted = false;
                }
            }
            lastSortedEle--;
        }
        System.out.println("Count : " + count);
    }


    public static void main(String[] args) {
        int[] array1 = {7, 1, 3, 2, 4, 5, 6};
        bubbleSort(array1);
        printArray(array1);



    }
}
