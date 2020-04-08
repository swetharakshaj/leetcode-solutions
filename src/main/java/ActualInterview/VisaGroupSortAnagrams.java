package ActualInterview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class VisaGroupSortAnagrams {

    /*

    Two strings are anagrams if they are permutations of each other. For example, "aaagmnrs" is an anagram of "anagrams".
    Given an array of strings, remove each string that is an anagram of an earlier string, then return the remaining array in sorted order.



    For example, given the strings s = ['code', 'doce', 'ecod', 'framer', 'frame'],  the strings 'doce' and 'ecod' are both anagrams of 'code'
    so they are removed from the list. The words 'frame' and 'framer' are not anagrams due to the extra 'r' in 'framer', so they remain.
            The final list of strings in alphabetical order is ['code', 'frame', 'framer'].

    Test cases:
            ['code', 'doce', 'ecod', 'framer', 'frame'] >> ['code', 'frame', 'framer']
            ['doce', 'ecod', 'framer', 'frame', 'code'] >> ? ['doce', 'frame', 'framer']
            ['framer', 'frame', 'doce', 'ecod',  'code'] >> ?
            */


        private static List<String> anagramSorter(String[] anagrams)
        {
        /*

        Map<?, String> =>
        <String, String>

        k, v = cdeo, code

        cdeo => ['code', 'doce', 'ecod']
        cdeo => 'code'
        ['framer'] =>
        ['frame'] =>

         O(n*mlogm) + nlogn
         n = length of array
         m = maxLength of a str
        */

            List<String> result = new ArrayList<>();
            if(anagrams == null || anagrams.length == 0)
                return result;
            if(anagrams.length == 1)
                return Arrays.asList(anagrams);
            Map<String, String> map = new HashMap<>();

            for(String str : anagrams)
            {
                char[] arr = str.toCharArray();
                Arrays.sort(arr);
                if(map.containsKey(new String(arr)))
                {
                    continue;
                }
                else {
                    map.put(new String(arr), str);
                }
            }

            result = new ArrayList(map.values());
            Collections.sort(result);
            return result;

        }


        public static void main(String args[] ) throws Exception {
            String[] anagrams = {"code", "doce", "ecod", "framer", "frame"};
            List<String> result = anagramSorter(anagrams);
            for(String str : result)
                System.out.println(str);
        }

}

