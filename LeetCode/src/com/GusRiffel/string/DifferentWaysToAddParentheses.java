package com.GusRiffel.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
//
//        The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.
//
//
//
//        Example 1:
//
//        Input: expression = "2-1-1"
//        Output: [0,2]
//        Explanation:
//        ((2-1)-1) = 0
//        (2-(1-1)) = 2
//        Example 2:
//
//        Input: expression = "2*3-4*5"
//        Output: [-34,-14,-10,-10,10]
//        Explanation:
//        (2*(3-(4*5))) = -34
//        ((2*3)-(4*5)) = -14
//        ((2*(3-4))*5) = -10
//        (2*((3-4)*5)) = -10
//        (((2*3)-4)*5) = 10
//
//
//        Constraints:
//
//        1 <= expression.length <= 20
//        expression consists of digits and the operator '+', '-', and '*'.
//        All the integer values in the input expression are in the range [0, 99].
public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    static Map<String, List<Integer>> map = new HashMap<>();

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> expressionList = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String p1 = expression.substring(0, i);
                String p2 = expression.substring(i + 1);
                List<Integer> l1 = map.getOrDefault(p1, diffWaysToCompute(p1));
                List<Integer> l2 = map.getOrDefault(p2, diffWaysToCompute(p2));
                for (Integer i1 : l1) {
                    for (Integer i2 : l2) {
                        int r = 0;
                        switch (c) {
                            case '+':
                                r = i1 + i2;
                                break;
                            case '-':
                                r = i1 - i2;
                                break;
                            case '*':
                                r = i1 * i2;
                                break;
                        }
                        expressionList.add(r);
                    }
                }
            }
        }
        if (expressionList.isEmpty()) {
            expressionList.add(Integer.valueOf(expression));
        }
        map.put(expression, expressionList);
        return expressionList;
    }
}
