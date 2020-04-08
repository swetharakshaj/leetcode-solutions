package Feb9;

import com.sun.deploy.util.StringUtils;

import javax.print.DocFlavor;

public class AlternatingCharacter {


//    You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.
////
////    Your task is to find the minimum number of required deletions.
////
////    For example, given the string , remove an  at positions  and  to make  in  deletions.

    public static int deletionsForAlternatingCharacter(String s) {
        if(s == null || s.isEmpty() || s.length() == 1)
            return 0;
       int numOfDeletions = 0;
       Boolean isLastA = s.charAt(0) == 'A'? true : false;
       Boolean isLastB = s.charAt(0) == 'B'? true: false;

       for(int i =1; i<=s.length()-1; i++)
       {
           if(s.charAt(i) == 'A') {
               if(isLastA) {
                   numOfDeletions++;
               }
               else {
                   isLastA = true;
                   isLastB = false;
               }
           }

           else if(s.charAt(i) == 'B') {
               if(isLastB)
               {
                   numOfDeletions++;
               }
               else {
                   isLastA = false;
                   isLastB = true;
               }
           }
       }

       return numOfDeletions;
    }

    public static void main(String[] args) {
        String s = "AAAA";
        String s1 = "BBBBB";
        String s2 = "ABABABAB";
        String s3 = "BABABA";
        String s4 = "AAABBB";

        System.out.println(deletionsForAlternatingCharacter(s));
        System.out.println(deletionsForAlternatingCharacter(s1));
        System.out.println(deletionsForAlternatingCharacter(s2));
        System.out.println(deletionsForAlternatingCharacter(s3));
        System.out.println(deletionsForAlternatingCharacter(s4));

    }

}
