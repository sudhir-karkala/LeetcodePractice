package com.leetcode.graphs;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * <p>
 * Each transformed word must exist in the word list.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * <p>
 * All words have the same length.
 * <p>
 * All words contain only lowercase alphabetic characters.
 * <p>
 * You may assume no duplicates in the word list.
 * <p>
 * You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @author sudhir on 20-Aug-2020
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjMap = new HashMap<>();
        int n = wordList.size();
        int strLength = wordList.get(0).length();
        int mismatch = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                mismatch = 0;
                for (int k = 0; k < strLength; k++) {
                    if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        mismatch++;
                    }
                }
                if (mismatch == 1) {
                    adjMap.computeIfAbsent(wordList.get(i), z -> new ArrayList<>()).add(wordList.get(j));
                    adjMap.computeIfAbsent(wordList.get(j), z -> new ArrayList<>()).add(wordList.get(i));
                }
            }
        }

        if (!adjMap.containsKey(beginWord)) {
            for (int i = 0; i < n; i++) {
                mismatch = 0;
                for (int k = 0; k < strLength; k++) {
                    if (beginWord.charAt(k) != wordList.get(i).charAt(k)) {
                        mismatch++;
                    }
                }
                if (mismatch == 1) {
                    adjMap.computeIfAbsent(beginWord, z -> new ArrayList<>()).add(wordList.get(i));
                }
            }
        }
        // this part of the code is needed in case the endWord is not part of the the given wordList
        /*for (int i = 0; i < n; i++) {
            mismatch = 0;
            for (int k = 0; k < strLength; k++) {
                if (endWord.charAt(k) != wordList.get(i).charAt(k)) {
                    mismatch++;
                }
            }
            if (mismatch == 1) {
                adjMap.computeIfAbsent(wordList.get(i), z -> new ArrayList<>()).add(endWord);
            }
        }*/

        Deque<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        int steps = 1;
        String last = beginWord;
//        System.out.println(adjMap);
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            visited.add(temp);
            if (adjMap.containsKey(temp)) {
                List<String> adjList = adjMap.get(temp);
                for (String str : adjList) {
                    if (str.equals(endWord)) {
                        steps++;
                        return steps;
                    }
                    if (!visited.contains(str)) {
                        visited.add(str);
                        queue.offer(str);
                    }
                }
            }
            if (temp.equals(last)) {
                steps++;
                last = queue.peekLast();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String begin1 = "hit";
        String end1 = "cog";
        List<String> wordList1 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(wordLadder.ladderLength(begin1, end1, wordList1));
        String begin2 = "hit";
        String end2 = "cog";
        List<String> wordList2 = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(wordLadder.ladderLength(begin2, end2, wordList2));
    }
}
