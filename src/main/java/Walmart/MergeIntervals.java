package Walmart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        void Interval() {

        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return this.start;
        }
    }

    public static List<Interval>  merge(int[][] intervals) {
        PriorityQueue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(Interval::getStart));
        for (int[] pair : intervals) {
            queue.add(new Interval(pair[0], pair[1]));
        }

        List<Interval> result = new ArrayList<>();

        result.add(queue.poll());

        while (!queue.isEmpty()) {
            Interval curr = queue.poll();
            int lastEleIndex = result.size() - 1;
            if (curr.start <= result.get(lastEleIndex).end) {
                Interval mergedInterval = new Interval(result.get(lastEleIndex).start, Math.max(curr.end, result.get(lastEleIndex).end));
                result.remove(lastEleIndex);
                result.add(mergedInterval);
            }
            else {
                result.add(curr);
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
//        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] input = {{1,4},{4,5}};

        List<Interval> result = merge(input);
        for(Interval interval : result){
            System.out.println("["+ interval.start+" , "+ interval.end+"]");
        }
    }
}
