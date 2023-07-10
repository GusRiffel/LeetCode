package com.GusRiffel.string.types;

//Two strings are considered close if you can attain one from the other using the following operations:
//
//        Operation 1: Swap any two existing characters.
//        For example, abcde -> aecdb
//        Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
//        For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
//        You can use the operations on either string as many times as necessary.
//
//        Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
//
//
//
//        Example 1:
//
//        Input: word1 = "abc", word2 = "bca"
//        Output: true
//        Explanation: You can attain word2 from word1 in 2 operations.
//        Apply Operation 1: "abc" -> "acb"
//        Apply Operation 1: "acb" -> "bca"
//        Example 2:
//
//        Input: word1 = "a", word2 = "aa"
//        Output: false
//        Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
//        Example 3:
//
//        Input: word1 = "cabbba", word2 = "abbccc"
//        Output: true
//        Explanation: You can attain word2 from word1 in 3 operations.
//        Apply Operation 1: "cabbba" -> "caabbb"
//        Apply Operation 2: "caabbb" -> "baaccc"
//        Apply Operation 2: "baaccc" -> "abbccc"
//
//
//        Constraints:
//
//        1 <= word1.length, word2.length <= 105
//        word1 and word2 contain only lowercase English letters.

import java.util.Arrays;

public class CloseStrings {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
    }

    public static boolean closeStrings(String word1, String word2) {
        int length1 = 0;
        int length2 = 0;

        if ((length1 = word1.length()) != (length2 = word2.length())) {
            return false;
        }

        byte[] word1Bytes = word1.getBytes();
        byte[] word2Bytes = word2.getBytes();
        int[] word1IntArray = new int[26];
        int[] word2IntArray = new int[26];
        method(word1Bytes, word1IntArray, length1);
        method(word2Bytes, word2IntArray, length2);
        for (int i = 0; i < 26; i++) {
            if (word1IntArray[i] > 0 ^ word2IntArray[i] > 0) {
                return false;
            }
        }

        Arrays.sort(word1IntArray);
        Arrays.sort(word2IntArray);

        return Arrays.equals(word1IntArray, word2IntArray);
    }

    public static void method(byte[] b, int[] c, int l) {
        while (l-- > 0) {
            c[b[l] - 97]++;
        }
    }
}
