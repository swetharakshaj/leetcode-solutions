package Arrays;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
//        if(height == null || height.length < 2)
//            return 0;
//
//        int firstVal = 0, firstIndex = -1, maxArea = 0;
//
//        for(int i=0; i<height.length; i++)
//        {
//            if(firstVal < height[i])
//            {
//                firstVal = height[i];
//                firstIndex = i;
//            }
//            else if(Math.min(firstVal, height[i])* (i-firstIndex) > maxArea)
//            {
//                maxArea = Math.min(firstVal, height[i])* (i-firstIndex);
//            }
//        }
//        return maxArea;

        if(height == null || height.length < 2)
            return 0;
        int start = 0, end = height.length-1;
        int area = 0;

        while(start < end)
        {
            area = Math.max(Math.min(height[start], height[end]) * (end-start), area);
            if(height[start] < height[end])
            {
                start++;
            }
            else {
                end--;
            }
        }

        return area;
    }
}
