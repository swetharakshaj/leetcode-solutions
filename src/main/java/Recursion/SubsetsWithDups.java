package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDups {

    /* 90 Subset II
    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
     */

    List<List<Integer>> result = new ArrayList<>();
    int sizeOfSubset;
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if(nums == null || nums.length == 0)
            return null;

        // sort the array
        Arrays.sort(nums);

        for(sizeOfSubset = 0; sizeOfSubset <= nums.length; sizeOfSubset++)
        {
            backTracking(0, new ArrayList<>(), nums);
        }

        return result;
    }

    private void backTracking(int start, ArrayList<Integer> curr, int[] nums)
    {
        if(curr.size() == sizeOfSubset)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=start; i<nums.length; i++)
        {
            if(i > start  && nums[i] == nums[i-1])
                continue;
            curr.add(nums[i]);
            backTracking(i+1, curr, nums);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args)
    {
        SubsetsWithDups  s = new SubsetsWithDups();
        List<List<Integer>> result = s.subsetsWithDup(new int[]{1, 2, 2});



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
