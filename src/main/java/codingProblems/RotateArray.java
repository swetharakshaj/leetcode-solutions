package codingProblems;



public class RotateArray {


    // Time - o(n^2)
    // space - o (1)
    public static void rotateArrayByK_BruteForce(int[] nums, int k) {
        if (nums.length <= 1)
            return;
        int temp = 0;
        int len = nums.length;
        k = k % len;
        for (int i = 1; i <= k; i++) {
            temp = nums[len - 1];
            for (int j = len - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    // time o(n)
    // space o(n)
    public static int[] rotateArrayUsingExtraSpace(int[] nums, int k) {
        if (nums.length <= 1)
            return nums;
        int count = 0;
        int len = nums.length;
        k = k % len;
        int[] result = new int[len];
        for(int i=len-k; i<len;i++) {
            result[count++] = nums[i];
        }
        for(int i=0; i<len-k; i++) {
            result[count++] = nums[i];
        }
        return result;
    }

    // time o(n)
    // space o(1)
    public static void rotateArrayUsingReversal(int[] nums, int k){

        if (nums.length <= 1)
            return;
        int len = nums.length;
        k = k % len;

        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
    }

    private static void reverse(int[] nums, int left, int right) {

        while(left  < right) {
            int temp = nums[left];
            nums[left]= nums[right];
            nums[right] = temp;
            left++;
            right--;
        }


    }

    public static void main (String[] args) {
        int[] nums = { 1,2,3,4,5,6,7};
//        rotateArrayByK_BruteForce(nums, 3);
        rotateArrayUsingReversal(nums, 3);
//        int[] result = rotateArrayUsingExtraSpace(nums, 3);
//        printArray(result);
        printArray(nums);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println();
    }
}




