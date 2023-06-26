package com.GusRiffel.string.types;
//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//        Example 2:
//
//        Input: s = "rat", t = "car"
//        Output: false
//
//
//        Constraints:
//
//        1 <= s.length, t.length <= 5 * 104
//        s and t consist of lowercase English letters.

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rac", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        int map1[] = new int[127];

        for (int i = 0; i < s.length(); i++) {
            map1[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            map1[t.charAt(i)]--;
        }
        return Arrays.stream(map1).distinct().count() == 1;
    }
}
