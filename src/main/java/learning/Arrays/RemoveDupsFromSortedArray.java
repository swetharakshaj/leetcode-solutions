package learning.Arrays;

public class RemoveDupsFromSortedArray {

//    public static int removeDupsMethod1(int[] nums) {
//
//        // first pass, replace dups with integer.max
//        int temp = nums[0], i=1;
//        int count =0;
//        while(i < nums.length)
//        {
//            while(temp == nums[i] && i < nums.length) {
//                nums[i] = Integer.MAX_VALUE;
//                count++;
//                i++;
//            }
//            temp = nums[i++];
//        }
//
//        printArray(nums);
//
//        // second pass, if current elem < prev, swap
//         int p =1, q=2;
//          while(p < q && q < nums.length) {
//              if(nums[p] >= nums[q])
//                  swap(nums, p, q);
//              p++;
//              q++;
//
//
//
//          }
//
//          return count;
//
//    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int removeDupsWithTwoPointers(int[] nums) {
        if(nums.length == 0)
                return 0;
        if(nums.length == 1)
            return 1;
        int i=0;

        for(int j= 1; j< nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }


    public static void main(String[] args) {
        int[] nums = { 1, 2,3 };
        System.out.println(removeDupsWithTwoPointers(nums));
        printArray(nums);

//        removeDupsMethod1(nums);


    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println();
    }
}
