package ActualInterview;

public class Reef_Sorting {


    // Given numbers are
// 12, 11, 13, 5, 6, 7

// Sorted numbers are
// 5, 6, 7, 11, 12, 13


    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

        public static void main(String[] args) {
            int[] array = {12, 11, 13, 5, 6, 7};
            sortArray(array);
            for(int i=0; i<array.length; i++)
            {
                System.out.print(array[i] + " ");
            }
        }

        private static void sortArray(int[] array)
        {
            if(array.length <=1) return;
            quickSort(array, 0, array.length-1);
        }

        private static void quickSort(int[] array, int start, int end)
        {
            if(start < end) {
                int pIndex = partition(array, start, end);
                quickSort(array, start, pIndex-1);
                quickSort(array, pIndex+1, end);
            }
        }

        private static int partition(int[] array, int start, int end) {

            int pivot = array[end];
            int partitionIndex = start;
            for(int i=start; i<=end-1; i++)
            {
                if(array[i] <= pivot)
                {
                    swap(array, i, partitionIndex);
                    partitionIndex++;

                }
            }
            swap(array, partitionIndex, end);
            return partitionIndex;
        }

        private static void swap(int[] array, int a, int b)
        {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }

}
