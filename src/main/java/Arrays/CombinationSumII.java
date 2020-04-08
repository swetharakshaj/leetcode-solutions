package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, result, new ArrayList<>(), 0);
        return result;

    }

    private static void findCombinations(int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> list, int start)
    {
        if(target < 0)
            return;
        if(target == 0)
        {
            result.add((ArrayList) list.clone());
            return;
        }

        for(int i=start; i<candidates.length; i++)
        {
            if(i == start || candidates[i] != candidates[i-1])
            {
                list.add(candidates[i]);
                findCombinations(candidates, target - candidates[i], result, list, i+1);
                list.remove(list.size()-1);
            }

        }


    }

    public static void main(String[] args)
    {
        List<List<Integer>> lists = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        for(List<Integer> list : lists)
        {
            System.out.println();
            for(int num : list)
            {
                System.out.print(num + " --> ");
            }
        }
    }
}
