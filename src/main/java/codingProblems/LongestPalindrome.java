package codingProblems;

import java.util.HashMap;

public class LongestPalindrome {

    private static int lengthOfLongestPalindrome (String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int result = 0;
        Boolean isOneFound = false;
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            int val = entry.getValue();

            if(val %2 == 1 && !isOneFound) {
                isOneFound = true;
                result+=val;
            }
            else  {
                result = result + ((val%2==1) ? (val-1) : val);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String test1 = "abccccdd";
        System.out.println("For string : " + test1 + " , length of longest palindrome is: " + lengthOfLongestPalindrome(test1));
    }
}
