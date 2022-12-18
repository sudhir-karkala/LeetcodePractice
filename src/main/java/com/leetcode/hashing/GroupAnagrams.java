package com.leetcode.hashing;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.<br/>
 * Note:<br/>
 * All inputs will be in lowercase.<br/>
 * The order of your output does not matter.
 *
 * @author sudhir on 21-Apr-2020
 */
public class GroupAnagrams {
    /*
        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String t = new String(temp);
            map.computeIfAbsent(t, z -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(strs));
    }
}
