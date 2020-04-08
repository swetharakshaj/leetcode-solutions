package visa;

public class CombinationSumIV {

    public static int combinationSum(int[] nums, int target)
    {
        if(nums == null || nums.length == 0 || target == 0)
            return 0;
        int[] dp = new int[target+1];
        dp[0] =1;

        for(int j=1; j<= target; j++)
        {
            for(int i=0; i<nums.length; i++)
            {
                if(j >= nums[i])
                {
                    dp[j] = dp[j]+ dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum(nums, 4));
    }
}
