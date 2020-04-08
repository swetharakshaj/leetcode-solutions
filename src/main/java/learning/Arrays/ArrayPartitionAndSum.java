package learning.Arrays;

import java.util.Arrays;

public class ArrayPartitionAndSum {

    public static int arrayPairSum(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        Arrays.sort(nums);

        int sum = 0;
        for (int i=0; i < nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;

    }

    public static int arrayPairSum1(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum1(nums));
    }

}
