package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsWithDups {

    private List<String> permute(String s)
    {
        if(s == null || s.length() == 0)
            return null;
        List<String> output = new ArrayList<>();
        int n = s.length();
        List<Character> charList = new ArrayList<>();
        for(int i=0; i<n; i++)
            charList.add(s.charAt(i));
        Collections.sort(charList);
        backTrack(charList, n, output, 0);
        return output;
    }

    private void backTrack(List<Character> list, int len, List<String> output, int start)
    {
        if(start == len)
        {
            output.add(convertToString(list));
            return;
        }

        for(int i=start; i<len; i++)
        {
            if(i > start && list.get(i).equals(list.get(i-1)) || !shouldSwap(list, start, i))
                continue;
            Collections.swap(list, i, start);

            backTrack(list, len, output, start+1);

            Collections.swap(list, i, start);
        }
    }

    private boolean shouldSwap(List<Character> list, int start, int curr) {
        for(int i=start; i<curr; i++)
        {
            if(list.get(i).equals(list.get(curr)))
                return false;
        }
        return true;

    }

    private String convertToString(List<Character> list)
    {
        StringBuilder str = new StringBuilder();
        for(char c : list)
            str.append(c);
        return str.toString();
    }

    public static void main(String[] args)
    {
        String str = "AABC";
        PermutationsWithDups obj = new PermutationsWithDups();
        List<String> result = obj.permute(str);
        for(String s : result)
        {
            System.out.println(s);
        }
    }
}
