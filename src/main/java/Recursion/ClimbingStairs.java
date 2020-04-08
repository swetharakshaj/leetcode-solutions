package Recursion;


import java.util.Arrays;

/*
if a person can climb 1, 2 or 3 steps at a time, how many ways can this person climb stairs with n steps
 */
public class ClimbingStairs {

    private static int waysToClimbStairs(int n)
    {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);

       return waysToClimbStairs(cache, n);
    }

    private static int waysToClimbStairs(int[] cache, int n)
    {
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        if(cache[n] > -1)
            return cache[n];
        cache[n] = waysToClimbStairs(cache, n-1) + waysToClimbStairs(cache, n-2) + waysToClimbStairs(cache, n-3);
        return cache[n];
    }

    public static void main(String[] args)
    {
        System.out.println(waysToClimbStairs(5));
    }
}
