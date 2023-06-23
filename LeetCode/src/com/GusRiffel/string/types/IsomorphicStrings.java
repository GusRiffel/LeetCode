package com.GusRiffel.string.types;

//Given two strings s and t, determine if they are isomorphic.
//
//        Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
//        Example 1:
//
//        Input: s = "egg", t = "add"
//        Output: true
//        Example 2:
//
//        Input: s = "foo", t = "bar"
//        Output: false
//        Example 3:
//
//        Input: s = "paper", t = "title"
//        Output: true
//
//
//        Constraints:
//
//        1 <= s.length <= 5 * 104
//        t.length == s.length
//        s and t consist of any valid ascii character.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> mapStringS = new HashMap<>();
        Map<Character, Integer> mapStringT = new HashMap<>();
        ArrayList<Integer> sequenceStringS = new ArrayList<>();
        ArrayList<Integer> sequenceStringT = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapStringS.containsKey(s.charAt(i))) {
                sequenceStringS.add(mapStringS.get(s.charAt(i)));
            } else {
                mapStringS.put(s.charAt(i), i);
                sequenceStringS.add(i);
            }

            if (mapStringT.containsKey(t.charAt(i))) {
                sequenceStringT.add(mapStringT.get(t.charAt(i)));
            } else {
                mapStringT.put(t.charAt(i), i);
                sequenceStringT.add(i);
            }
        }

        for (int i = 0; i < sequenceStringT.size(); i++) {
            if (sequenceStringS.get(i) != sequenceStringT.get(i)) {
                return false;
            }
        }

        return true;
    }

    //Optimal solution using ASCII chars as index
//    public static boolean isIsomorphic(String s, String t) {
//
//        int map1[]=new int[127];
//        int map2[]=new int[127];
//
//        for(int i=0;i<s.length();i++)
//        {
//            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
//                return false;
//
//            map1[s.charAt(i)]=i+1;
//            map2[t.charAt(i)]=i+1;
//        }
//        return true;
//    }
}
