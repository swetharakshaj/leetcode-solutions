package ActualInterview;

import java.util.*;

public class NextDoorIntervals {

    /*
Alice = [(13.5, 14), (15.75, 17)]
Bob = [(9, 12), (13, 14), (14, 16)]
Eve =  [(9, 11), (12.5, 13.5), (14, 15), (16, 18)]
Mallory = [(0, 9), (12, 24)]

For simplicity, let’s represent times as numbers between 0 and 24 and the times people are busy as (start_time, end_time) pairs. For example, (13.5, 14) means that Alice is busy from 1:30PM-2PM.

Given a list of people's schedules, write a function to return a list of the time intervals all the people in the list are free to meet.
For the example above, here's some sample output:

f(Alice, Bob) => [(0, 9), (12, 13), (17, 24)]
f(Bob, Mallory) => []
f(Alice, Bob, Eve) => [(0, 9), (12, 12.5), (18, 24)]
*/

    static class Interval {
        double start;
        double end;

        Interval()
        {

        }

        Interval(double start, double end)
        {
            this.start = start;
            this.end = end;
        }

        double getStart()
        {
            return this.start;
        }
    }
    private static List<Interval> findFreeBlocks(List<List<Interval>> intervals)
    {


        /*


        1. Consolidate all the interval  blocks into a priroity queue sorted based on start time
        2. poll

        */
        List<Interval> freeInterval = new ArrayList<Interval>();
        PriorityQueue<Interval> busyBlocks = new PriorityQueue<Interval>(Comparator.comparingDouble(Interval::getStart));

        for(List<Interval> list : intervals)
        {
            for(Interval in : list)
                busyBlocks.add(in);
        }

        Interval curr;
        while(!busyBlocks.isEmpty())
        {
            curr = freeInterval.size() == 0? busyBlocks.poll() : freeInterval.get(freeInterval.size()-1);
            Interval temp = busyBlocks.poll();

            if(temp.start > curr.end)
            {
                Interval free = new Interval(curr.end, temp.start);

                if(freeInterval.size() == 0)
                    freeInterval.add(free);
                else
                {
                    curr.end = temp.start;
                    freeInterval.set(freeInterval.size()-1, curr);
                }
            }
        }
        return freeInterval;
    }


    private List<Interval> freeIntervalsCalculator(List<List<Interval>> intervals)
    {

        if (intervals == null || intervals.size() == 0)
            return null;

        // create start and end list

        List<Double>  startList  = new ArrayList<>();
        List<Double> endList = new ArrayList<>();

        for(List<Interval> list: intervals)
        {
            for(Interval in : list)
            {
                startList.add(in.start);
                endList.add(in.end);
            }
        }

        // sort lists

        Collections.sort(startList);
        Collections.sort(endList);

        List<Interval> freeIntervals = new ArrayList<>();

        double start = startList.get(0);
        double end = endList.get(0);

        if(start > 0)
            freeIntervals.add(new Interval(0, start));


        for(int i=1; i<startList.size(); i++)
        {
            if(startList.get(i) <= end)
            {
                end = Math.max(endList.get(i), end);
            }
            else {
                start = startList.get(i);
                freeIntervals.add(new Interval(end, start));
                end = endList.get(i);
            }
        }

        if(endList.get(endList.size()-1) < 24)
            freeIntervals.add(new Interval(endList.get(endList.size()-1), 24));
        return freeIntervals;
    }

    public static void main(String[] args) {
        /* Alice = [(13.5, 14), (15.75, 17)]
            Bob = [(9, 12), (13, 14), (14, 16)] */
        NextDoorIntervals  obj = new NextDoorIntervals();
        List<Interval> alice = Arrays.asList(new Interval(13.5, 14), new Interval(15.75, 17));
        List<Interval> bob = Arrays.asList(new Interval(9, 12), new Interval(13, 14), new Interval(14, 16));
        List<Interval> result = obj.freeIntervalsCalculator(Arrays.asList(alice, bob));

        for(Interval in : result)
        {
            System.out.println(in.start+ " to " + in.end);
        }
    }
}
