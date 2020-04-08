package codingProblems;

public class ClimbingStairsProblem {

    // PROBLEM STATEMENT
//    You are climbing a stair case. It takes n steps to reach to the top.
//
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//    Note: Given n will be a positive integer.



    // iterative
    private static int numOfWaysIterative (int n) {
       if (n <=1) {
           return 1;
       }

        int temp;
        int prev = 1;
        int curr = 1;

        for (int i = 3; i <=n; i++) {
            temp = curr;
            curr+=prev;
            prev = temp;
        }

        return curr;
    }

    // recursive
    private static int numOfWaysRecursive(int n) {
        if(n==0) {
            return 0;
        }
        if (n<=2) {
            return 1;
        }
        int numOfWays = numOfWaysRecursive(n-1) + numOfWaysRecursive(n-2 );
        return  numOfWays;
    }
    //memoization

    private static int numOfWaysMemo(int n, int[] memo) {
        if(n < 0) {
            return 0;
        }
        else if( n == 1) {
            return 1;
        }

        if(memo[n] == 0) {
            memo[n] =  numOfWaysMemo(n-1, memo) + numOfWaysMemo(n-2, memo);
        }

        return memo[n];
    }

    //DP

    private static int numOfWaysDp(int n) {


        if(n <0 )
        {
            return 0;
        }

        if(n <=1) {
            return 1;
        }
        int[] paths = new int[n];

        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for(int i=3; i<n; i++) {
            paths[i] = paths[i-1] + paths[i-2];
        }
        return paths[n-1];
    }

    //Iterative - improved solution

    private static int numOfWaysI(int n) {
        if(n < 0) return 0;
        if (n <=1) return 1;
        int[] paths = {1, 1};
        for (int i=3; i<=n; i++) {
            int count = paths[0] + paths[1];
            paths[0] = paths[1];
            paths[1]  = count;
        }
        return paths[1];
    }

    public static void main(String[] args) {
        int[] memo = new int[6+1];
       //  System.out.println("Memo " + numOfWaysMemo(6, memo));
      //                    System.out.println("DP " + numOfWaysDp(6));
         System.out.println("Improved Iterative approach " + numOfWaysI(6));
//        System.out.println("Iterative approach  " + numOfWaysIterative(5));
//        System.out.println("Recursive appraoch  " + numOfWaysRecursive(5));
    }
}
