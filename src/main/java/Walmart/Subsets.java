package Walmart;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(nums == null || nums.length == 0){
            return result;
        }
        int s = 0;
        for(int n:nums){
            s = result.size();
            for(int i = 0;i<s;i++){
                List<Integer> set = new ArrayList<>(result.get(i));
                set.add(n);
                result.add(set);
            }
        }
        return result;
    }


    public static void main(String[] args)
    {
        List<List<Integer>> result  = subsets(new int[]{1, 2, 3});

        for(List l : result)
        {
            System.out.println();
            for(int i=0; i<l.size(); i++)
            {
                System.out.print(l.get(i) + "-->" );
            }
        }
    }

}
