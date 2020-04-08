package Arrays;

import java.util.Arrays;

public class ArrayManipulation {

    private static long arrayManipulation(int n, int[][] queries) {
        int[] arr = new int[n];
        Arrays.fill(arr, 0);
        int maxSum = 0 ;
//        int maxSum = queries[0][2];
        int temp = 0;

        for(int i=0; i<queries.length; i++)
        {
            int startIndex = queries[i][0]-1;
            int endIndex = queries[i][1]-1;
            int value = queries[i][2];

//            for(int j = startIndex; j<=endIndex; j++)
//            {
//                arr[j]+=value;
//                temp = arr[j];
//                maxSum = Math.max(temp, maxSum);
//            }
            arr[startIndex]+=value;
            if(endIndex < n) arr[endIndex]-=value;
        }

        for(int i=0; i<arr.length; i++)
        {
            temp+=arr[i];
            if(temp > maxSum) maxSum = temp;
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[][] arr = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}, {2, 4, 400}};
        System.out.println(arrayManipulation(5, arr));
    }
}
