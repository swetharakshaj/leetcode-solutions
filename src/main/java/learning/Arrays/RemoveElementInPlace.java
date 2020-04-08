package learning.Arrays;

import static learning.Arrays.ArrayPlusOne.printArray;

public class RemoveElementInPlace {

    public static int removeElement(int[] nums, int val) {
        int numOfVals = 0, len = nums.length;

        if(len == 0)
            return 0;

            while(numOfVals < len) {
                if(nums[numOfVals] == val)
                {
                nums[numOfVals] = nums[len-1];
                len--;
                }
                else {
                    numOfVals++;
                }
        }
        return numOfVals;

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        System.out.println(removeElement(nums, 3));
        printArray(nums);
    }
}
