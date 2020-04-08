package Arrays;

public class      MinNumOfSwapsToAscendingOrder {
    private static int numOfSwaps(int[] arr)
    {
        int swaps = 0;
        int i = 0;
        while( i < arr.length)
        {
            if(arr[i] != i+1)
            {
                swap(arr, i, arr[i]-1);
                swaps++;
            }
            else
                i=i+1;
        }
        return swaps;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] arr = { 7, 1, 3, 2, 4, 5, 6};
        System.out.println(numOfSwaps(arr));

    }
}
