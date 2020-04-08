package learning.Strings;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        if(s == null || s.isEmpty()) return "";
        s = s.trim();
        String[] str = s.split("\\s+");
        String result = new String();
        for(int i = str.length-1; i>0; i--){
             result = result.concat(str[i] + " ");

        }
        result = result.concat(str[0]);
        return result;
    }

    public static String reverseChars(String s) {
        if(s == null || s.isEmpty()) return "";
        s = s.trim();

        List<String> strs = Arrays.asList(s.split("\\s+"));
        StringBuilder result = new StringBuilder();
        for(String str: strs) {
            result.append(new StringBuffer(str).reverse().toString()+" ");
        }

        return result.toString().trim();
    }

    private static void reverse(String s1) {
        int start = 0, end = s1.length()-1;
        char[] words = s1.toCharArray();

        while(start < end) {
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
        s1 = words.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = "  hello world!  ";
        String s2 = "a good   example";

//        System.out.println(reverseWords(s));
//        System.out.println(reverseWords(s1));
//        System.out.println(reverseWords(s2));

        System.out.println(reverseChars(s));
    }
}
