package codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CheckIf2NumsInListAddUptoK {

    private static Boolean if2NumsAddUptoK(int[] num, int target) {
        boolean isPresent = false;
        List<Integer> list = Arrays.stream(num).boxed().collect(Collectors.toList());
        for (Integer i:
             list) {
            isPresent = list.contains(target-i);
            if(isPresent) break;
        }
        return isPresent;
    }

    private static int[] return2NumsAddingUptoK(int[] nums, int target) {
        int[] result = new int[2];
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (Integer i:
             list) {
            if(list.contains(target-i)) {
                result[0] = i;
                result[1] = target-i;
                break;
            }
        }
        return result;

    }

    private static int[] returnIndicesAddingUptoK(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++ ){
            if(map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            }
            else {
                map.put(nums[i], i);
            }
        }
        return result;

    }

    public static void main(String args[]) {
        int[] num = new int[] {2, 7, 11, 15};
        int[] test = new int[0];
//        System.out.println(if2NumsAddUptoK(num, 9));
//
//        int[] result = return2NumsAddingUptoK(num, 9);
//        System.out.println(result[0] + " and " + result[1]);

        int[] result1 = returnIndicesAddingUptoK(test, 9);
        System.out.println(result1[0] + " and " + result1[1]);
    }

}
