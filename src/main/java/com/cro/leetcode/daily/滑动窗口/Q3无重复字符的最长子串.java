package com.cro.leetcode.daily.滑动窗口;

import java.util.HashMap;

/**
 * @author cro
 * @description https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Q3无重复字符的最长子串 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            // 子串长度
            int max = 0;
            // 记录开始位置 （左指针）
            int left = 0;
            // 记录下标索引位置 用以决定需要收缩窗口的位置
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                // 重复 缩小窗口
                if (map.containsKey(s.charAt(i))) {
                    // 左指针 上一个重复字符排除在窗口之外（索引+1）
                    // 有可能上一个字符已经在窗口外
                    left = Math.max(map.get(s.charAt(i)) + 1, left);
                }
                // 更新当前位置字符的索引
                map.put(s.charAt(i), i);
                // 比较现在的子串和之前的最大值
                // 当前子串长度 当前索引 - 起始位置索引（左指针位置） + 1 因为索引从0开始
                // 有可能没有之前无重复子串长
                max = Math.max(i - left + 1, max);
            }

            return max;
        }
    }
}
