package coding_challenge_30_day;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
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
}
