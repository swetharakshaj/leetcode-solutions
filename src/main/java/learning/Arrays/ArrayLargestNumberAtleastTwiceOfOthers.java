package learning.Arrays;

public class ArrayLargestNumberAtleastTwiceOfOthers {

    public static int returnIndexOfLargestNumAtleastTiwceAsOthers(int[] nums) {
        int largestNumIndex = 0;
        for(int i=0; i< nums.length; ++i)
        {
            if(nums[i] > nums[largestNumIndex])
                largestNumIndex = i;
        }
        int tempLen =0;
        for(int i=0; i<nums.length; ++i) {
            if(i!= largestNumIndex && nums[largestNumIndex] >= 2* nums[i])
                tempLen++;
        }
         int returnIndex = tempLen == nums.length-1? largestNumIndex : -1;
        return returnIndex;
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 1, 0};
        int[] b = {1, 2, 3, 4};
        int[] c = {0};
        int[] d = {1, 2};
        int[] e = {};

        System.out.println(returnIndexOfLargestNumAtleastTiwceAsOthers(c));
        System.out.println(returnIndexOfLargestNumAtleastTiwceAsOthers(d));
        System.out.println(returnIndexOfLargestNumAtleastTiwceAsOthers(e));
    }
}
