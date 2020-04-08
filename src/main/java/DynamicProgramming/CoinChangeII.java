package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeII {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int coin : coins)
        {
            for(int i=1;i<amount+1;i++)
            {
                if(i>=coin)
                {
                    dp[i]+=dp[i-coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args)
    {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

}
