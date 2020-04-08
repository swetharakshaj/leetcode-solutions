package Recursion;

import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

 */
public class CoinChangeII {

    private int coinChangeII(int[] coins, int amount)
    {
        if(coins == null || coins.length == 0 || amount == 0)
            return 0;
        int dp[] = new int[amount+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for(int coin : coins)
        {
            for(int i=1; i<=amount; i++)
            {
                if(i >= coin)
                {
                    dp[i]+=dp[i-coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args)
    {
        CoinChangeII obj = new CoinChangeII();
        System.out.println(obj.coinChangeII(new int[]{1,2,5}, 5));
    }
}
