package com.gn.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class 无重复字符的最长子串 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba"));


    }

    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }




    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            if (list.contains(c)) {
                list = list.subList(list.indexOf(c) + 1, list.size());
            }
            list.add(c);

            if (result < list.size()) {
                result = list.size();
            }
        }

        return result;
    }
}
