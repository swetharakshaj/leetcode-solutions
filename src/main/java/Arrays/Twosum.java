package Arrays;

import java.util.HashMap;

public class Twosum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if(nums == null || nums.length <2) return result;

        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++)
        {
            int temp = target - nums[i];
            if(!indexMap.containsKey(temp))
            {
                indexMap.put(nums[i], i);
            }
            else {
                return new int[]{i, indexMap.get(temp)};
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
