package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0) return new ArrayList();
        HashMap<String, List> result = new HashMap<String, List>();
        int[] count = new int[26];
        for(String str : strs)
        {
            Arrays.fill(count, 0);
            char[] arr = str.toCharArray();
            for(char c : arr) count[c-'a']++;

            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<count.length; i++)
            {
                sb.append("#");
                sb.append(count[i]);
            }
            String countStr = sb.toString();

            if(!result.containsKey(countStr))
            {
                result.put(countStr, new ArrayList());
            }
            result.get(countStr).add(str);
        }

        return new ArrayList(result.values());
    }

    public static void main(String[] args)
    {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(strs);

        for(List<String> list : result)
        {
            System.out.print("[");
            for(String str: list)
            {
                System.out.print(str +", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }


}
