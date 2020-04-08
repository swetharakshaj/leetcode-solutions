package ActualInterview;


import java.io.*;
import java.util.*;


// Main class should be named 'Solution'
/*
Problem

Given 2 sets of intervals.

Interval is defined with left and right border and discrete points, like [2, 3], [0, 0], etc.

Set of intervals is non intersected set of sorted intervals, for example: [0, 0], [2, 2], [5, 10] is a valid set of intervals, but :
* [0, 0], [1, 2] is not valid, because you can write it as [0, 2].
* [0, 2], [1, 5] is not valid as well, since these two intervals intersect.

You need to find the AND operation of these two sets. For example:

1st set: [0, 2], [5, 10], [16, 20], [25, 26], [28, 30]
2nd set: [1, 5], [11, 12], [14, 18], [20, 23]

AND Result: [1, 2], [5, 5], [16, 18], [20, 20]

*/

class UberIntersectionOfSets {

    private static ArrayList<int[]> andOpertation(List<int[]> list1, List<int[]> list2)
    {
        ArrayList<int[]> result = new ArrayList<int[]>();
        if(list1.size() == 0 || list2.size() == 0) return result;
        int prevUpperBound = -1;
        int i=0, j=0;

        while(i < list1.size() && j < list2.size())
        {
            if(i!=0 && j!=0)
            {
                if(checkPrevUpperBound(prevUpperBound, list1.get(i), list2.get(j)))
                {
                    result.add(new int[]{prevUpperBound, prevUpperBound});
                }
            }
            int[] tempResult = findIntersection(list1.get(i), list2.get(j));
            if(tempResult[0] != -1 && tempResult[1] != -1)
            {
                result.add(tempResult);
            }
            prevUpperBound = list1.get(i)[1] > list2.get(j)[1] ? list1.get(i)[1] : list2.get(j)[1];
            i++;
            j++;

        }

        return result;
    }

    private static boolean checkPrevUpperBound(int val, int[] x, int[] y)
    {
        return val == x[0] || val == y[0];
    }

    private static int[] findIntersection(int[] x, int[] y) {
        int[] pair = {-1, -1};

        if(x[0] >= y[0] && x[0] <=y[1])
        {
            pair[0] = x[0];
        }
        if(y[0] >= x[0] && y[0] <=x[1])
        {
            pair[0] = y[0];
        }
        if(pair[0] != -1)
        {
            pair[1] = x[1] > y[1] ? y[1] : x[1];
        }
        return pair;
    }

    public static void main(String[] args) {
        ArrayList<int[]> list1 = new ArrayList<>();
        list1.add(new int[] {0,2});
        list1.add(new int[] {5,10});
        list1.add(new int[] {16, 20});
        list1.add(new int[] {25, 26});
        list1.add(new int[] {28, 30});



        ArrayList<int[]> list2 = new ArrayList<>();
        list2.add(new int[] {1,5});
        list2.add(new int[] {11,12});
        list2.add(new int[] {14,18});
        list2.add(new int[] {20,23});

        ArrayList<int[]> result = andOpertation(list1, list2);
        for(int i=0; i<result.size(); i++) {
            printArray(result.get(i));
        }



    }

    private static void  printArray(int[] arr)
    {
        System.out.println("["+ arr[0]+ "," + arr[1] +"] ");
    }
}




/*
import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Main class should be named 'Solution'

Problem

Given 2 sets of intervals.

Interval is defined with left and right border and discrete points, like [2, 3], [0, 0], etc.

Set of intervals is non intersected set of sorted intervals, for example: [0, 0], [2, 2], [5, 10] is a valid set of intervals, but :
* [0, 0], [1, 2] is not valid, because you can write it as [0, 2].
* [0, 2], [1, 5] is not valid as well, since these two intervals intersect.

You need to find the AND operation of these two sets. For example:

1st set: [0, 2], [5, 10], [16, 20], [25, 26], [28, 30]
2nd set: [1, 5], [11, 12], [14, 18], [20, 23]

AND Result: [1, 2], [5, 5], [16, 18], [20, 20]



class Solution {

    private static ArrayList<int[]> andOpertation(List<int[]> list1, List<int[]> list2)
    {
        ArrayList<int[]> result = new ArrayList<int[]>();
        if(list1.size() == 0 || list2.size() == 0) return result;
        int prevUpperBound = -1;
        int i=0, j=0;

        while(i < list1.size() && j < list2.size())
        {
            if(i!=0 && j!=0)
            {
                if(checkPrevUpperBound(prevUpperBound, list1.get(i), list2.get(j)))
                {
                    result.add(new int[]{prevUpperBound, prevUpperBound});
                }
            }
            int[] tempResult = findIntersection(list1.get(i), list2.get(j));
            if(tempResult[0] != -1 && tempResult[1] != -1)
            {
                result.add(tempResult);
            }
            prevUpperBound = Math.max(list1.get(i)[1], list1.get(j)[1]);
            i++;
            j++;

        }

        return result;
    }

    private static boolean checkPrevUpperBound(int val, int[] x, int[] y)
    {
        return val == x[0] || val == y[0];
    }

    private static int[] findIntersection(int[] x, int[] y) {
        //initialze with -1 and override if there's overlap
        int[] pair = {-1, -1};

        if(doesXOverlapWithY(x, y))
        {
            pair[0] = x[0];
        }
        if(doesXOverlapWithY(y, x))
        {
            pair[0] = y[0];
        }
        if(pair[0] != -1)
        {
            pair[1] = Math.min(x[1], y[1]);
        }
        return pair;
    }

    private static boolean doesXOverlapWithY(int[] x, int[] y){
        return x[0] >= y[0] && x[0] <=y[1];
    }
    public static void main(String[] args) {
        ArrayList<int[]> list1 = new ArrayList<>();
        list1.add(new int[] {0,2});
        list1.add(new int[] {5,10});
        list1.add(new int[] {16, 20});
        list1.add(new int[] {25, 26});
        list1.add(new int[] {28, 30});



        ArrayList<int[]> list2 = new ArrayList<>();
        list2.add(new int[] {1,5});
        list2.add(new int[] {11,12});
        list2.add(new int[] {14,18});
        list2.add(new int[] {20,23});

        ArrayList<int[]> result = andOpertation(list1, list2);
        for(int i=0; i<result.size(); i++) {
            printArray(result.get(i));
        }



    }

    private static void  printArray(int[] arr)
    {
        System.out.println("["+ arr[0]+ "," + arr[1] +"] ");
    }
}

 */

