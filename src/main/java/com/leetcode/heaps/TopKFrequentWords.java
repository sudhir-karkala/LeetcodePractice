package com.leetcode.heaps;

import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.<br/>
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.<br/>
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2 <br/>
 * Output: ["i", "love"]
 *
 * @author sudhir on 19-Jun-2020
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            count.put(words[i], count.getOrDefault(words[i], 0) + 1);
        }
        List<String> list = new ArrayList<>(count.keySet());
        Collections.sort(list, (o1, o2) -> {
            if (count.get(o1) == count.get(o2)) {
                return o1.compareTo(o2);
            } else {
                return count.get(o2) - count.get(o1);
            }
        });
        return list.subList(0, k);
    }

    public static void main(String[] args) {
        TopKFrequentWords t = new TopKFrequentWords();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(t.topKFrequent(words, k));
    }
}
