package com.GusRiffel.string.types;

//An additive number is a string whose digits can form an additive sequence.
//
//        A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
//
//        Given a string containing only digits, return true if it is an additive number or false otherwise.
//
//        Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
//
//
//
//        Example 1:
//
//        Input: "112358"
//        Output: true
//        Explanation:
//        The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
//        1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//        Example 2:
//
//        Input: "199100199"
//        Output: true
//        Explanation:
//        The additive sequence is: 1, 99, 100, 199.
//        1 + 99 = 100, 99 + 100 = 199
//
//
//        Constraints:
//
//        1 <= num.length <= 35
//        num consists only of digits.
public class AdditiveNumber {
    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("8917"));
    }

    public static boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        return dfs(num, 0, 0, 0, 0);
    }
    private static boolean dfs(String num, int index, long prevSum, long prevNum, int count) {
        if (index == num.length()) {
            return count > 2;
        }

        long currentNum = 0;
        for (int i = index; i < num.length(); i++) {
            currentNum = currentNum * 10 + (num.charAt(i) - '0');

            if (i > index && num.charAt(index) == '0') {
                break;
            }

            if (count < 2 || currentNum == prevSum) {
                if (dfs(num, i + 1, prevNum + currentNum, currentNum, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
