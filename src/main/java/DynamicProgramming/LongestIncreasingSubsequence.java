package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = Integer.MIN_VALUE;

        for(int i=1; i < nums.length; i++)
        {
            int j=0;
            while(j < i)
            {
                if(nums[j] < nums[i])
                {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    result = Math.max(dp[i], result);
                }
                j++;

            }
        }
        return result;
    }

    public static void main(String[] ags)
    {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }

}
