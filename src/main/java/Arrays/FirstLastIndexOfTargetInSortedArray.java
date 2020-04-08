package Arrays;

public class FirstLastIndexOfTargetInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int[] result = new int[2];

        result[0] = firstOccurenceIndex(nums, target);
        result[1] = lastOccurenceIndexd(nums, target);


        return result;

    }

    private static int firstOccurenceIndex(int[] nums, int target)
    {
        int index=-1;
        int start = 0;
        int end  = nums.length-1;
        while(start <= end)
        {
            int midpoint = start +  (end-start) /2;
            if(nums[midpoint] >= target)
            {
                end = midpoint-1;
            }
            else {
                start = midpoint +1;
            }

            if(nums[midpoint] == target) index= midpoint;
        }


        return index;
    }

    private static int lastOccurenceIndexd(int[] nums, int target)
    {
        int index=-1;
        int start = 0;
        int end  = nums.length-1;
        while(start <= end)
        {
            int midpoint = start +  (end-start) /2;
            if(nums[midpoint] <= target)
            {
                start = midpoint+1;
            }
            else {
                end = midpoint-1;
            }

            if(nums[midpoint] == target) index= midpoint;
        }
        return index;
    }

    public static void main(String[] args)
    {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] result = searchRange(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
