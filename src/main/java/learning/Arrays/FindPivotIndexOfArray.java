package learning.Arrays;



public class FindPivotIndexOfArray {

    // fails for negative numbers
    public static int pivotIndex(int[] nums) {
        int pivotindex = -1;
        if (nums.length <=2)
            return pivotindex;
        int leftSum = nums[0], rightSum =nums[nums.length-1];
        int i = 0, j = nums.length-1;
        while(i<j) {
            if(leftSum == rightSum && j-i==2)
                return java.lang.Math.abs((i+j)/2);
            else if(leftSum < rightSum)
            {
                i++;
                leftSum+=nums[i];
            }
            else if(leftSum > rightSum)
            {
                j--;
                rightSum+=nums[j];
            }
            else {
                i++;
                j--;
            }
        }
        return pivotindex;
    }

    public static int pivotIndex1(int[] nums) {
        int sum =0, leftSum = 0;
        for(int x : nums)
            sum+=x;
        for(int i=0; i<nums.length; ++i) {
            if(leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

        public static void main(String[] args) {
        int a[] = {1,7,3,6,5,6};
        int a1[] = {1, 2, 3};
        int a2[] = {1, 2};
        int a3[] = {-1,-1,-1,-1,-1,-1};
        int a4[] = {-1,-1,-1,-1,-1,0};

        System.out.println(pivotIndex1(a));
        System.out.println(pivotIndex1(a1));
        System.out.println(pivotIndex1(a2));
        System.out.println(pivotIndex1(a3));
        System.out.println(pivotIndex1(a4));
    }
}
