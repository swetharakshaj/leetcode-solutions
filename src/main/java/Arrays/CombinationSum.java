package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int helperCallCount = 1;
        helper(candidates, target, res, new ArrayList<>(), 0, helperCallCount);
        return res;
    }

    private static void helper(int[] cans, int target, List<List<Integer>> res, ArrayList<Integer> list, int index, int callCount) {

        System.out.println("Helper call count:" + callCount);
        if(target < 0) return;
        if(target == 0) {
            res.add((ArrayList) list.clone());
            return;
        }
        for(int i=index; i<cans.length; i++) {
            System.out.println("i = " + i);
            System.out.println("Candidates[i] = " + cans[i]);
            list.add(cans[i]);
            printList(list);
            helper(cans, target-cans[i], res, list, i, ++callCount);
            list.remove(list.size()-1);
            System.out.println("After removing last element");
            printList(list);
        }


    }

    private static void printList(ArrayList<Integer> list)
    {
        if(list.size() > 0)
        {
            for(int num : list)
            {
                System.out.print(num + "--> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        List<List<Integer>> list = combinationSum(new int[]{2,3,6,7}, 7);
    }


}
