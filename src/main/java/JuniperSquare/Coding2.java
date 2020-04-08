package JuniperSquare;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Coding2 {


    private static boolean is_common_password(String password) {
        return true;
    }

    public static List<String> all_common_passwords(int maxLength, char[] set) {
        List<String> result = new ArrayList<>();
        helper(maxLength, set, result, "");
        return result;
    }

    private static void helper(int maxLength, char[] set, List<String> result, String s) {

        if (s.length() >= maxLength) {
            return;
        }

        for (int i = 0; i < set.length; i++) {
            StringBuilder str = new StringBuilder(s);
            str.append(set[i]);
            // add to result
            result.add(str.toString());
            // call helper with string = append string to set.get(i)
            helper(maxLength, set, result, str.toString());
        }


    }

    public static void main(String[] args)
    {
        List<String> passwords = all_common_passwords(3, new char[]{'a', 'b', 'c'});

        for(String str : passwords)
        {
            System.out.println(str);
        }
    }


}
