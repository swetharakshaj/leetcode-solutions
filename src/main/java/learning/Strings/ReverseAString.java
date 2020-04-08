package learning.Strings;

public class ReverseAString {

    private static void reverseString(char[] s) {
        if(s.length <=1)
            return;
        int i =0;
        int j = s.length-1;
        while(i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[j];
        s[j] = s[i];
        s[i] = temp;
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o', 'v'};
        reverseString(s);
        printArray(s);
    }

    private static void printArray(char[] s) {
        for(char c : s)
            System.out.print(c + " ");
    }
}
