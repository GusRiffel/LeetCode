package com.GusRiffel.string.parenthesis;

import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.
//
//
//        Example 1:
//
//        Input: s = "()"
//        Output: true
//        Example 2:
//
//        Input: s = "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: s = "(]"
//        Output: false
//
//
//        Constraints:
//
//        1 <= s.length <= 104
//        s consists of parentheses only '()[]{}'.

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
