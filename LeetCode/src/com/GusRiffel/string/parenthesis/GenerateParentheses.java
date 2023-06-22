package com.GusRiffel.string.parenthesis;

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
//        Example 1:
//
//        Input: n = 3
//        Output: ["((()))","(()())","(())()","()(())","()()()"]
//        Example 2:
//
//        Input: n = 1
//        Output: ["()"]
//
//
//        Constraints:
//
//        1 <= n <= 8

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }

    public static List<String> generateParentheses(int n) {
        List<String> parenthesesList = new ArrayList<>();
        recursion(parenthesesList, "", 0, 0, n);
        return parenthesesList;
    }

    public static void recursion(List<String> list, String str, int open, int close, int n){

        if(str.length() == n*2){
            list.add(str);
            return;
        }

        if(open < n)
            recursion(list, str+"(", open+1, close, n);
        if(close < open)
            recursion(list, str+")", open, close+1, n);
    }
}
