package Recursion;


import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

 */
public class CoinChange {

    private int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0)
            return -1;
        if(amount <=0)
            return -1;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for(int coin : coins)
        {
            for(int i=1; i<=amount; i++)
            {
                if(i >= coin)
                {
                    if(1+dp[i-coin] < dp[i])
                        dp[i] = 1+dp[i-coin];
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE-1? dp[amount] : -1;
    }

    public static void main(String[] args)
    {
        CoinChange obj = new CoinChange();
        System.out.println(obj.coinChange(new int[]{2}, 5));
    }

}
