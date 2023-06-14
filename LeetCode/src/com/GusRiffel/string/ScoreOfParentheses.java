package com.GusRiffel.string;

//Given a balanced parentheses string s, return the score of the string.
//
//        The score of a balanced parentheses string is based on the following rule:
//
//        "()" has score 1.
//        AB has score A + B, where A and B are balanced parentheses strings.
//        (A) has score 2 * A, where A is a balanced parentheses string.
//
//
//        Example 1:
//
//        Input: s = "()"
//        Output: 1
//        Example 2:
//
//        Input: s = "(())"
//        Output: 2
//        Example 3:
//
//        Input: s = "()()"
//        Output: 2
//
//
//        Constraints:
//
//        2 <= s.length <= 50
//        s consists of only '(' and ')'.
//        s is a balanced parentheses string.

import java.util.Arrays;
import java.util.List;

public class ScoreOfParentheses {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()()(()))"));
    }

    public static int scoreOfParentheses(String s) {
        int length = s.length();
        int depth = 0;
        int result = 0;

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            // if `(` increase the depth
            if(ch == '(')
                depth++;
            else {
                // if `)` decrease the depth
                --depth;
                // check if a balanced pair is getting formed, if yes update the result
                if(s.charAt(i-1) == '(')
                    result += Math.pow(2, depth);
            }
        }
        return result;
    }
}
