package com.GusRiffel.string.parenthesis;

//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
//        substring.

//        Example 1:

//        Input: s = "(()"
//        Output: 2
//        Explanation: The longest valid parentheses substring is "()".
//        Example 2:

//        Input: s = ")()())"
//        Output: 4
//        Explanation: The longest valid parentheses substring is "()()".
//        Example 3:

//        Input: s = ""
//        Output: 0

//        Constraints:

import java.util.Stack;

//        0 <= s.length <= 3 * 104
//        s[i] is '(', or ')'.
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        if (s.length() < 2) {
            return 0;
        }

        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')'){
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}
