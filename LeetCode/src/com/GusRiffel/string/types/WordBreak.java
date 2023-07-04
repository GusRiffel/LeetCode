package com.GusRiffel.string.types;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//        Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//
//
//        Example 1:
//
//        Input: s = "leetcode", wordDict = ["leet","code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//        Example 2:
//
//        Input: s = "applepenapple", wordDict = ["apple","pen"]
//        Output: true
//        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//        Note that you are allowed to reuse a dictionary word.
//        Example 3:
//
//        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//        Output: false

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Integer>h1=new HashMap<>();
        for(String str:wordDict){
            h1.put(str,1);
        }
        int n=s.length();
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(s,0,h1,dp)==1;
    }
    public static int helper(String s,int i,HashMap<String,Integer>h1,int dp[]){
        if(i==s.length()){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        for(int j=i;j<s.length();j++){
            if(isfound(s.substring(i,j+1),h1)){
                int ans= helper(s,j+1,h1,dp);
                dp[i]=ans;
                if(ans==1){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static boolean isfound(String s, HashMap<String,Integer> h1){
        if(h1.containsKey(s)){
            return true;
        }
        return false;
    }
}
