package Recursion;


/*
find unique number of BST generated using numbers 1 through n
 */
public class UniqueBST {

    private static int numOfUniqueBSTs(int n)
    {
        if(n <= 2)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n ; i++)
        {
            for(int j=1; j<=i; j++)
            {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        printArray(dp);
        return dp[n];

    }

    private static void printArray(int[] arr) {
        for(int n : arr)
            System.out.println(n);
    }

    public static void main(String[] args)
    {
        System.out.println(numOfUniqueBSTs(5));
    }

}
