package Walmart;

public class TrappingWater {

    public static int trap(int[] height) {
        if(height == null || height.length < 03){
            return 0;
        }

        int [] leftArray = new int[height.length];
        int [] rightArray = new int [height.length];
        int result = 0;

        leftArray[0] = 0;
        int len = height.length;
        rightArray[height.length-1] = 0;
//        // leftArray populates the max height at left of i
//        for(int i=1; i<leftArray.length;i++){
//            leftArray[i] = Math.max(leftArray[i-1], height[i-1]);
//        }
//        // rightArray populates the max height at right of i
//
//        for(int i=rightArray.length-2;i>=0;i--){
//            rightArray[i] = Math.max(rightArray[i+1], height[i+1]);
//        }

        for(int i=1; i<len; i++)
        {
            leftArray[i] = Math.max(leftArray[i-1], height[i-1]);
            rightArray[len-1-i] = Math.max(rightArray[len-i], height[len-i]);
        }

        // calculate carry capacity at each level
        int min = 0;
        for(int i=0; i<height.length;i++){
            min = Math.min(rightArray[i], leftArray[i]);
            if(min > 0 && min - height[i] >0){
                result+= (min - height[i]);
            }
        }

        return result;

    }

    public static void main(String[] args)
    {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
