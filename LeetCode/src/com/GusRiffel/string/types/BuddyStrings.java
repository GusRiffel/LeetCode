package com.GusRiffel.string.types;

//Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
//
//        Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
//
//        For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
//
//
//        Example 1:
//
//        Input: s = "ab", goal = "ba"
//        Output: true
//        Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
//        Example 2:
//
//        Input: s = "ab", goal = "ab"
//        Output: false
//        Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
//        Example 3:
//
//        Input: s = "aa", goal = "aa"
//        Output: true
//        Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
//
//
//        Constraints:
//
//        1 <= s.length, goal.length <= 2 * 104
//        s and goal consist of lowercase letters.
public class BuddyStrings {
    public static void main(String[] args) {
        System.out.println(buddyStrings("ababec", "ababce"));
    }

    public static boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        int diff = 0;
        boolean f = false;
        int[] sCharsArray = new int[26];
        int[] goalCharsArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int sCharValue = s.charAt(i) - 'a';
            int goalCharValue = goal.charAt(i) - 'a';
            sCharsArray[sCharValue]++;
            goalCharsArray[goalCharValue]++;
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (sCharsArray[i] != goalCharsArray[i]) {
                return false;
            }
            if (sCharsArray[i] > 1) {
                f = true;
            }
        }
        return diff == 2 || (diff == 0 && f);
    }
}
