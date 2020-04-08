package Walmart;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    static final String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return result;
        recursiveCall(digits, result, "", 0, mapping);
        return result;
    }

    private static void recursiveCall(String digits, List<String> result, String combination, int index, String[] mapping)
    {
        System.out.println("Combination till now: "+ combination);

        if(combination.length() == digits.length())
        {
            result.add(combination);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for(int i=0; i<letters.length(); i++)
        {
            System.out.println("Letters : "+ letters);
            System.out.println("Letter being processed : "+ letters.charAt(i));
            recursiveCall(digits, result, combination + letters.charAt(i), index+1, mapping);
        }
    }

    public static void main(String[] args)
    {
        List<String> list = letterCombinations("23");
        for(String str : list)
        {
            System.out.println(str);
        }
    }
}
