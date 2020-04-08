package Walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParanthesis {

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        helper(result, n, 0, 0, "", 0, 0);
        return result;
    }

    private static void helper(List<String> result, int n, int openParanCount, int closedParanCount, String currStr, int openRecursionCount, int closeRecursionCount) {

        System.out.println("Open Recursion :" + openParanCount + " closed recursion : " + closeRecursionCount);
        if(currStr.length() == 2*n)
        {
            System.out.println(currStr);
            result.add(currStr);
            return;
        }

        if(openParanCount < n)
        {
            helper(result, n, openParanCount+1, closedParanCount, currStr+"(", openRecursionCount+1, closeRecursionCount);
        }

        if(closedParanCount < openParanCount)
        {
            helper(result, n, openParanCount, closedParanCount+1, currStr+")", openRecursionCount, closeRecursionCount+1);
        }
    }

    public static void main(String[] args)
    {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();

        List<String> result = generateParenthesis(3);
        for(String str : result)
        {
            System.out.println(str);
        }
    }


}
