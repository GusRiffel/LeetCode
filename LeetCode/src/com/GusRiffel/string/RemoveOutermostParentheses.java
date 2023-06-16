package com.GusRiffel.string;

//A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
//
//        For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
//        A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
//
//        Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
//
//        Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
//
//
//
//        Example 1:
//
//        Input: s = "(()())(())"
//        Output: "()()()"
//        Explanation:
//        The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
//        After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
//        Example 2:
//
//        Input: s = "(()())(())(()(()))"
//        Output: "()()()()(())"
//        Explanation:
//        The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
//        After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
//        Example 3:
//
//        Input: s = "()()"
//        Output: ""
//        Explanation:
//        The input string is "()()", with primitive decomposition "()" + "()".
//        After removing outer parentheses of each part, this is "" + "" = "".
//
//
//        Constraints:
//
//        1 <= s.length <= 105
//        s[i] is either '(' or ')'.
//        s is a valid parentheses string.

import java.util.Stack;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String s) {
        int count = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && count++ > 0) {
                result += s.charAt(i);
            }
            if (s.charAt(i) == ')' && count-- > 1) {
                result += s.charAt(i);
            }
        }
        return result;
    }

// BETTER PERFORMANCE
//    public static String removeOuterParenthesess(String S) {
//        StringBuilder sb = new StringBuilder();
//        int counter = 0;
//        for(char c : S.toCharArray()){
//            if(c == '('){
//                if(counter != 0) sb.append(c);
//                counter++;
//            }
//            else{
//                counter--;
//                if(counter != 0) sb.append(c);
//            }
//        }
//
//        return sb.toString();
//    }
}
