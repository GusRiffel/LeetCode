package com.GusRiffel.string;

import java.util.*;

//Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
//
//        Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: s = "()())()"
//        Output: ["(())()","()()()"]
//        Example 2:
//
//        Input: s = "(a)())()"
//        Output: ["(a())()","(a)()()"]
//        Example 3:
//
//        Input: s = ")("
//        Output: [""]
//
//
//        Constraints:
//
//        1 <= s.length <= 25
//        s consists of lowercase English letters and parentheses '(' and ')'.
//        There will be at most 20 parentheses in s.
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("((()())()"));
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null) return result;

        Set<String> checked = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        checked.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                result.add(s);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String string = s.substring(0, i) + s.substring(i + 1);

                if (!checked.contains(string)) {
                    queue.add(string);
                    checked.add(string);
                }
            }
        }
        return result;
    }

    static boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }
}
