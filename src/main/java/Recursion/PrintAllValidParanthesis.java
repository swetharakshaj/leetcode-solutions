package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllValidParanthesis {

    List<String> result;

    private List<String> allValidParanthesis(int n)
    {
        result = new ArrayList<>();
        if(n == 0)
            return result;
        if(n == 1)
        {
            result.add("()");
            return result;
        }

        // openCount, closeCount, curr String,
        backTracking("", n, n, 2*n);
        return result;
    }

    private void backTracking(String curr, int openCnt, int closeCnt, int totalLen)
    {
        if(curr.length() == totalLen)
        {
            result.add(curr);
            return;
        }

        if(openCnt > 0)
            backTracking(curr+"(", openCnt-1, closeCnt, totalLen);

        if(closeCnt > openCnt)
            backTracking(curr+")", openCnt, closeCnt-1, totalLen);
    }

    public static void main(String[] args)
    {
        PrintAllValidParanthesis obj = new PrintAllValidParanthesis();
        obj.allValidParanthesis(3);
        for(String str : obj.result)
            System.out.println(str);
    }
}
