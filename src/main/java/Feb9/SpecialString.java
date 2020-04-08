package Feb9;

public class SpecialString {

    // INCOMPLETE

    /*A string is said to be a special string if either of two conditions is met:

    All of the characters are the same, e.g. aaa.
    All characters except the middle one are the same, e.g. aadaa.
    A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.

    For example, given the string s= mnonopoo , we have the following special substrings:
    {m, n, o, n, o, p, o, o, non, o o, opo, oo}*/

    public static int numOfSpecialString(String s) {
        int len = s.length();
        if(s == null || s.isEmpty())
            return 0;
        if(s.length() == 1)
            return 1;
        int result = len;

        for(int i=0; i<len-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1))
                result++;
            else {
                if (i+2< len && s.charAt(i) == s.charAt(i + 2)) {
                    result++;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
//        String s = "mnonopoo";
        String s = "aaaa";

        System.out.println(numOfSpecialString(s));
    }
}
