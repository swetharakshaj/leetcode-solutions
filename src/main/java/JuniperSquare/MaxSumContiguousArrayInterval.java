package JuniperSquare;

import java.util.Arrays;

public class MaxSumContiguousArrayInterval {

    static class MaxSubArrayMeta {
        int maxSum;
        int startIndex;
        int endIndex;

        MaxSubArrayMeta() {
        }

        MaxSubArrayMeta(int sum, int start, int end) {
            maxSum = sum;
            startIndex = start;
            endIndex = end;
        }

        void printMeta() {
            System.out.println("MaxSum is " + maxSum);
            System.out.println("Sub array start: " + startIndex + ", end: " + endIndex);
        }
    }

    private static MaxSubArrayMeta findMaxSumInterval(int[] nums) {

        MaxSubArrayMeta result = new MaxSubArrayMeta();
        if (nums == null || nums.length == 0)
            return result;
        if (nums.length == 1)
            return new MaxSubArrayMeta(nums[0], 0, 0);

        // start, end to hold the boundary of window
        int start = 0;
        int end = 0;
        int tempStart = 0;

        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;

        for (int i = 0; i < nums.length; i++) {
            tempSum = tempSum + nums[i];
            if (tempSum < 0) {
                tempSum = 0;
                tempStart++;
            }

            if (tempSum > maxSum) {
                maxSum = tempSum;
                start = tempStart;
                end = i;
            }
        }


        // handler for when all int in array are negative
        if (start == 1 && end == 0 && maxSum == 0) {
            Arrays.sort(nums);
            result.maxSum = nums[nums.length-1];
            result.startIndex = 0;
            result.endIndex = 0;
        } else {
            result.maxSum = maxSum;
            result.startIndex = start;
            result.endIndex = end;
        }

        return result;

    }

    public static void main(String[] args) {
        MaxSubArrayMeta result = findMaxSumInterval(new int[]{-2, 3, 5, -4, 6});
        result.printMeta();

        MaxSubArrayMeta result1 = findMaxSumInterval(new int[]{-2, -3, -5, -4, -6});
        result1.printMeta();

        MaxSubArrayMeta result2 = findMaxSumInterval(new int[]{-2});
        result2.printMeta();

        MaxSubArrayMeta result3 = findMaxSumInterval(new int[]{3});
        result3.printMeta();

    }
}
