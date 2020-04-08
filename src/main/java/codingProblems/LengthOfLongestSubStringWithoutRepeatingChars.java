package codingProblems;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubStringWithoutRepeatingChars {

    private static int returnLength(String s) {
        Set<Character> charMap = new HashSet<Character>();
        int len = 0;
        int right=0;
        int left=0;

        if(s.length() == 0 ) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        while(right < s.length()) {
            if(charMap.contains(s.charAt(right))) {
                charMap.remove(s.charAt(left));
                left++;
            }
            else {
                charMap.add(s.charAt(right++));
                len = Math.max(len, charMap.size());
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String st = "dvdf";
        System.out.println(returnLength(st));

    }
}


