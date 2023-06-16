package com.GusRiffel.string;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '('
                    ||
                    s.charAt(i) == ']' && !stack.empty() &&  stack.peek() == '['
                    ||
                    s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
            {
                stack.pop();
            } else if (s.charAt(i) == ')'
                    ||
                    s.charAt(i) == ']'
                    ||
                    s.charAt(i) == '}')
            {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}
