package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationWithoutDups {



    private List<String> permute(String s)
    {
        if(s ==  null || s.length() == 0)
            return null;
        List<Character> charList = new ArrayList<>();
        for(int i=0; i<s.length(); i++)
        {
            charList.add(s.charAt(i));
        }

        int n = charList.size()-1;
        List<String> permutations = new ArrayList<>();
        backTrack(charList, 0, permutations, n);
        return permutations;
    }

    private void backTrack(List<Character> list, int start, List<String> output, int len)
    {
            if(start == len+1)
            {
                output.add(convertToString(list));
//                return;
            }

            for(int i=start; i<=len; i++)
            {
                Collections.swap(list, i, start);

                backTrack(list, start+1, output, len);

                Collections.swap(list, i, start);
            }
    }

    public String convertToString(List<Character> list)
    {
        StringBuilder str = new StringBuilder();
        for(char c : list)
            str.append(c);
        return str.toString();
    }

    public static void main(String[] args)
    {
        String str = "ABC";
        PermutationWithoutDups obj = new PermutationWithoutDups();
        List<String> result = obj.permute(str);
        for(String s : result)
        {
            System.out.println(s);
        }
    }
}
