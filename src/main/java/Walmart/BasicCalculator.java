package Walmart;

import java.util.Stack;

public class BasicCalculator {

    public static int calculate(String s) {
        int sum = 0, start = 0;

        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        while (start < s.length()) {
            if (Character.isDigit(s.charAt(start))) {
                sum *= 10;
                sum += s.charAt(start) - '0';
            }

            if (!Character.isDigit(s.charAt(start)) && s.charAt(start) != ' ' || start == s.length() - 1) {
                if (sign == '+') {
                    stack.push(sum);
                } else if (sign == '-') {
                    stack.push(-sum);
                } else if (sign == '*') {
                    stack.push(stack.pop() * sum);
                } else if (sign == '/') {
                    stack.push(stack.pop() / sum);
                }
                sign = s.charAt(start);
                sum = 0;
            }
            start++;
        }

        int res = 0;
        for (int i : stack) {
            res += i;
        }

        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(calculate("3*10+24/6"));
    }
}
