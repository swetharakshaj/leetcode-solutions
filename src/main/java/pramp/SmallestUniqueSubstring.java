package pramp;

import java.io.*;
import java.util.*;

public class SmallestUniqueSubstring {


        static String getShortestUniqueSubstring(char[] arr, String str)
        {
            if(str.isEmpty()) return "";
            if(str.length() < arr.length) return "";

            int start = 0;
            int uniqueCounter =0;
            HashMap<Character, Integer> charMap = new HashMap<>();
            populateCharMap(charMap, arr);

            String result = "";
            int tempLen = 0;
            int len = Integer.MAX_VALUE;

            for(int i=0; i<str.length(); i++) {
                String temp = "";
                if(charMap.keySet().contains(str.charAt(i)))
                {
                    if(charMap.get(str.charAt(i)) == 0)
                        uniqueCounter++;
                    charMap.replace(str.charAt(i), charMap.get(str.charAt(i))+1);
                }

                while(uniqueCounter == arr.length)
                {
                    tempLen = i - start + 1;
                    if(tempLen == uniqueCounter)
                        return str.substring(start, i+1);
                    temp = str.substring(start, i+1);
                    len = result.isEmpty() ? len : result.length();
                    result = len < temp.length() ? result : temp;
                    if(charMap.keySet().contains(str.charAt(start))) {
                        charMap.replace(str.charAt(start), charMap.get(str.charAt(start))-1);
                        if(charMap.get(str.charAt(start)) == 0) uniqueCounter--;
                    }
                    start++;
                }
            }
            return result;
        }

        static void populateCharMap(HashMap<Character, Integer> charMap, char[] arr)
        {
            for(int i =0; i<arr.length; i++)
            {
                charMap.put(arr[i], 0);
            }
        }


        public static void main(String[] args) {
            char[] arr ={'A', 'B', 'C'};
            String str = "ADOBECODEBANCDDD";
            System.out.println(getShortestUniqueSubstring(arr, str));
        }

    }

