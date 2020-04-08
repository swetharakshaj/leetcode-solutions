package JuniperSquare;

public class MaxContSubArrayDP {


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

    private static MaxSubArrayMeta maxSubArraySum(int[] nums)
    {
        if(nums == null || nums.length == 0)
        {
            return new MaxSubArrayMeta();
        }

        int len = nums.length;
        int[] dp = new int[len];
        int[] pos = new int[len];
        dp[0] = nums[0];
        pos[0] = 0;

        for(int i=1; i<len; i++)
        {
            if(nums[i] > dp[i-1] + nums[i])
            {
                dp[i] = nums[i];
                pos[i] = i;
            }
            else {
                dp[i] = dp[i-1] + nums[i];
                pos[i] = i-1;
            }
        }

        int maxSum = dp[0];
        int start = 0;
        int end = 0;
        for(int j=1; j<len; j++)
        {
            if(dp[j] > maxSum)
            {
                maxSum = dp[j];
                start = pos[j];
                end = j;
            }

        }

        return new MaxSubArrayMeta(maxSum, start, end);
    }

    public static void main(String[] args) {
        MaxContSubArrayDP.MaxSubArrayMeta result = maxSubArraySum(new int[]{-2, 3, 5, -4, 6});
        result.printMeta();

        MaxContSubArrayDP.MaxSubArrayMeta result1 = maxSubArraySum(new int[]{-2, -3, -5, -4, -6});
        result1.printMeta();

        MaxContSubArrayDP.MaxSubArrayMeta result2 = maxSubArraySum(new int[]{-2});
        result2.printMeta();

        MaxContSubArrayDP.MaxSubArrayMeta result3 = maxSubArraySum(new int[]{3});
        result3.printMeta();

    }
}
