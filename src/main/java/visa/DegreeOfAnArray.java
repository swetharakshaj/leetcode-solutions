package visa;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DegreeOfAnArray {
    static class Num {
        int freq;
        int left;
        int right;

        public Num(int freq, int left, int right)
        {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }
    public static int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Num> countMap = new HashMap<Integer, Num>();
        int degree = 0;
        int result = Integer.MAX_VALUE;;
        for(int i=0; i<nums.length; i++)
        {
            if(!countMap.containsKey(nums[i])) {
                countMap.put(nums[i], new Num(1, i, i));
            }
            else {
                Num num = countMap.get(nums[i]);
                num.freq = num.freq+1;
                num.right = i;
                countMap.put(nums[i], num);
            }
            degree = Math.max(degree, countMap.get(nums[i]).freq);
        }

        int maxFreq = Collections.max(countMap.values().stream().map(num -> num.freq).collect(Collectors.toList()));

        for(Integer val : countMap.keySet())
        {
            if(countMap.get(val).freq == maxFreq)
            {
                Num num = countMap.get(val);
                result = Math.min(result, num.right-num.left+1);
            }
        }

        return result;

    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,2,3,1};
        System.out.println(findShortestSubArray(arr));
    }
}
