package learning.Arrays;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int numOfOnes = 0, temp = 0;

        for(int i=0; i < nums.length; i++) {
            if(nums[i] == 1) {
                temp++;
            }
            else {
                numOfOnes = Math.max(numOfOnes, temp);
                temp = 0;
            }
        }

        return Math.max(numOfOnes, temp);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}

