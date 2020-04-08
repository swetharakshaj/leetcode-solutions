package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeProblem {

    public static int coinChange(int[] coins, int amount) {
        int[] numCoins = new int[amount+1];
        // int[] lastCoinPicked = new int[amount];


        Arrays.fill(numCoins, Integer.MAX_VALUE-1);
        numCoins[0] = 0;

        for(int j=0; j<coins.length; j++)
        {
            for(int i=1; i<=amount; i++)
            {
                if(i >= coins[j])
                {
                    if(1+numCoins[i-coins[j]] < numCoins[i])
                    {
                        numCoins[i] = 1+numCoins[i-coins[j]];
                    }
                }
            }
        }
        return numCoins[amount] != Integer.MAX_VALUE-1 ? numCoins[amount] : -1;
    }

    public static void main(String[] args)
    {
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }
}
