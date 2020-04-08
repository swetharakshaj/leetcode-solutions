package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
    Given a set of numbers, generate subsets of size 0  to n (size of the set)
     */
    /*
    Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
     */

    List<List<Integer>> output = new ArrayList<>();
    private int k;
    // DP way

    private static List<List<Integer>> getSubsets(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int n : nums)
        {
            List<List<Integer>> subSets = new ArrayList<>();
            for(List<Integer> curr : result)
            {
                List<Integer> temp = new ArrayList<>(curr);
                temp.add(n);
                subSets.add(temp);
            }

            for(List<Integer> tempList : subSets)
            {
                result.add(tempList);
            }
        }
        return result;
    }


    private  List<List<Integer>> getSubsetsBackTracking(int[] nums)
    {

        for(k = 0; k <= nums.length; k++)
        {
            backtrack(0, nums, new ArrayList<>());
        }

        return output;

    }

    private void backtrack(int start, int[] nums, ArrayList<Integer> curr) {

        if(curr.size() ==  k)
        {
            output.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start; i<nums.length; i++){
            curr.add(nums[i]);

            backtrack(i+1, nums, curr);

            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args)
    {
        List<List<Integer>> result = getSubsets(new int[]{1, 2, 3});

        Subsets s = new Subsets();

        result = s.getSubsetsBackTracking(new int[]{1, 2, 3});

        for(List<Integer> list : result)
        {
            System.out.print("[");
            for(int n : list)
            {
                System.out.print(n + ",");
            }
            System.out.print("]");
        }
    }

}
