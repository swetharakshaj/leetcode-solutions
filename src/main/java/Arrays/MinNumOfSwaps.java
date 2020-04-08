package Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinNumOfSwaps {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        if(q == null || q.length == 0)
        {
            System.out.println("Not valid");
        }
        int len = q.length;
        int swapCounter =0;
        int i=0;
        while(i< len-1)
        {
            int posDiff = Math.abs(i-(q[i]-1));
            if(posDiff == 1 && Math.abs(q[i+1] - q[i]) == 1)
            {
                swapCounter+=1;
                i+=2;
            }
            else if(posDiff == 2 && Math.abs(q[i+1] - q[i]) == 2)
            {
                swapCounter+=2;
                i+=3;
            }
            else if(posDiff == 0 && q[i+1] - q[i] == 1)
            {
                i++;
            }
            else {
                swapCounter = Integer.MAX_VALUE;
                break;
            }
        }

        if(swapCounter == Integer.MAX_VALUE)
        {
            System.out.println("Too chaotic");
        }
        else
        {
            System.out.println(swapCounter);
        }
    }

    static void numBribes(int[] q) {
        int count = 0;
        for(int i = q.length-1; i>=0; i--) {
            if(q[i] - (i+1) > 2)
            {
                System.out.println("Too chaotic");
                return;
            }
            for(int j=Math.max(0, q[i]-2); j<i; j++)
            {
                if(q[j] > q[i]) count++;
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
       int[] q = {1,2, 5, 3, 7, 8, 6, 4};
        numBribes(q);
        }


    }

