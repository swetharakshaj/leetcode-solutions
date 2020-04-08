package learning;

import java.util.PriorityQueue;

public class KthLargest {

        PriorityQueue<Integer> queue;
        int size = 0;
        public KthLargest(int k, int[] nums) {
            this.size = k;
            this.queue = new PriorityQueue<>();
            for(int i : nums)
            {
                add(i);
            }
        }

        public int add(int val) {
            this.queue.add(val);
            while(this.queue.size() > this.size)
            {
                this.queue.poll();
            }
            int ele = this.queue.peek();
            return ele;
        }

        public static void main(String[] args) {
            int arr[] = {4,5,8,2};
            int k =3;
            KthLargest ele = new KthLargest(k, arr);
            System.out.println(ele.add(3));

        }

}
