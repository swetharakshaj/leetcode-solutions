package learning;

import java.util.HashMap;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        
        int size =0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                map.replace(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
        }

        if(map.keySet().size() == 1) return map.values().iterator().next();
        boolean singleoccurence = false;
        for(int i : map.values())
        {
            if(i%2 == 0)
                size+=i;
            else
                {
                    if(i>1) {
                        size = size+i-1;
                    }
                    singleoccurence = true;
                }
        }
        

        return singleoccurence ? size+1 : size;

    }
}
