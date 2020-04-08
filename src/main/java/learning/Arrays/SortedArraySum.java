package learning.Arrays;

import static java.util.Arrays.binarySearch;
import static learning.Arrays.ArrayPlusOne.printArray;

public class SortedArraySum {

    public static int[] twoSum(int[] numbers, int target) {
        if(numbers.length <= 1) {
            return new int[]{-1, -1};
        }
        int start = 0, end = numbers.length - 1;
        int sum = 0;
        while(start < end) {
            sum = numbers[start] + numbers[end];
            if(sum == target)
                return new int[]{start+1, end+1};
            if(sum < target)
                start++;
            if(sum > target)
                end--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
        int[] nums = {-3, 3, 4, 90};
        int target = 0;
        printArray(twoSum(nums, target));
    }


}
