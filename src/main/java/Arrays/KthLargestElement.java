package Arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

        public static int findKthLargest(int[] nums, int k) {
            Queue queue=new PriorityQueue<>(k);
            for(int i=0;i<nums.length;i++){
                queue.add(nums[i]);
                if(queue.size()>k){
                    queue.poll();
                }
            }
            return (int)queue.peek();
        }

        public static void main(String[] args)
        {
            System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        }
    }

