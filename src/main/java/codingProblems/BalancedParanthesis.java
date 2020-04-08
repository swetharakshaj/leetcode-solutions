package codingProblems;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParanthesis {

    private boolean isBalanced(String paran) {

        if(paran.length() == 0) return true;
        if(paran.length()%2 != 0) return false;

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> st = new Stack<Character>();
        Character curr;
        for(int i=0; i< paran.length(); i++) {
            curr = paran.charAt(i);
            if(map.containsKey(curr))
            {
                st.push(curr);
            }
            else {
                if(map.containsValue(curr)) {
                    if(!st.empty() && map.get(st.peek()).equals(curr))
                    {
                        st.pop();
                    }
                    else
                        return false;
                }
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {

        BalancedParanthesis b = new BalancedParanthesis();
        // System.out.println(b.isBalanced("()[]{}"));
        System.out.println(b.isBalanced("{[]}"));
//        System.out.println(b.isBalanced("(]"));
//        System.out.println(b.isBalanced("()"));

    }

}
