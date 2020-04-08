package learning.Arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        if(nums.length <= 1)
            return;
        for(int lastNonZeroAt = 0, j = 0; j<nums.length; j++){
            if (nums[j] != 0) {
                swap(nums, lastNonZeroAt++, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
