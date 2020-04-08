package learning.Strings;

public class NeedleInHayStack {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(null))
            return 0;
        return haystack.indexOf(needle);
    }
}
