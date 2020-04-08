package ActualInterview;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestInArray {

    private static int kthLargest(int[] nums, int k)
    {
        // 1. Create priority queue & to customize the comparator to sort in reverse
        // 2. One pass on nums, add it to queue
        // keep polling it k times and return the value

        // edge checks

        if(nums == null)
        {
            return Integer.MIN_VALUE;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int n : nums)
        {
            queue.add(n);
        }

        int kthLargest = queue.poll();
        for(int i=1; i<k; i++)
        {
            kthLargest = queue.poll();
        }

        return kthLargest;
    }



    public static void main(String[] args)
    {
        System.out.println(kthLargest(new int[]{4, 3, 9, 7, 4, 2, 11}, 3));
    }
}
