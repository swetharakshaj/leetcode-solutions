package learning.Arrays;

public class MinSubArrayLength {

    private static int minLength(int[] nums, int s) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) {
            if(nums[0] >= s) return 1;
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                if (minLen >= (i - start + 1)) {
                    minLen = i - start + 1;
                }
                sum -= nums[start];
                start++;

            }
        }

        if (s > sum && minLen == Integer.MAX_VALUE) return 0;
        return minLen;

    }

    public static void main(String[] agrs) {
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {2,7};


        int s = 7;

        System.out.println(minLength(nums, s));
    }
}
