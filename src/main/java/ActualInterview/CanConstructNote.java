package ActualInterview;

import java.util.HashMap;

public class CanConstructNote {
    public static boolean canConstructLetter(String text, String note) {


        HashMap<Character, Integer> textMap = new HashMap<>();

        for(int i=0; i<text.length(); i++)
        {
            if(text.charAt(i) != ' ')
            {
                if(!textMap.containsKey(text.charAt(i)))
                {
                    textMap.put(text.charAt(i), 1);
                }
                else
                {
                    textMap.replace(text.charAt(i), textMap.get(text.charAt(i))+1);
                }
            }
        }

        for(int i=0; i<note.length(); i++)
        {
            if(note.charAt(i) != ' ') {
                if (!textMap.containsKey(note.charAt(i)) || textMap.get(note.charAt(i)) == 0)
                    return false;
                textMap.replace(note.charAt(i), textMap.get(note.charAt(i)) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        String text = "abcdefghijklmnopqrstuvwxyz";
        String note ="a b c d e f g h i j k l m n o p q r s t u v w x y z";

        System.out.println(canConstructLetter(text, note));

    }
}
