package codingProblems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

//    public static int romanToInt(String s) {
//
//        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
//           put('I', 1 );
//           put('V', 5 );
//           put('X', 10);
//           put('L', 50);
//           put('C', 100);
//           put('D', 500);
//           put('M', 1000);
//        }};
//
//        char next;
//        char curr;
//        boolean splCase = false;
//        int result = 0;
//        if(s.length() == 0)
//            return 0;
//        if(s.length() == 1)
//            return map.get(s.charAt(0));
//        for(int i=0; i<s.length()-1; i++) {
//            if(!splCase) {
//                curr = s.charAt(i);
//                next = s.charAt(i+1);
//                // check for special cases - spl case logic
//                if (map.get(curr) < map.get(next)){
//                    splCase = true;
//                    result+=(map.get(next)-map.get(curr));
//                }
//                // normal case logic
//                else {
//                    result+=map.get(curr);
//                }
//            }
//            else {
//                splCase = false;
//            }
//        }
//
//        if(!splCase) result+=map.get(s.charAt(s.length()-1));
//        return result;
//    }


    static Integer c2i(Character c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int current = c2i(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            int next = c2i(s.charAt(i + 1));
            if (current < next) {
                sum -= current;
            } else {
                sum += current;
            }
            current = next;
        }
        sum += current;
        return sum;
    }

    public static void main(String args[]) {
//        String s1 = "III";
//        System.out.println("Result  for " + s1 + " is " + romanToInt(s1));
//
//        String s2 = "IV";
//        System.out.println("Result  for " + s2 + " is " + romanToInt(s2));
//
//        String s3 = "IX";
//        System.out.println("Result  for " + s3 + " is " + romanToInt(s3));
//
//        String s4 = "LVIII";
//        System.out.println("Result  for " + s4 + " is " + romanToInt(s4));

        String s5 = "MCMXCIV";
        System.out.println("Result  for " + s5 + " is " + romanToInt(s5));

    }
}
