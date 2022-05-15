package com.cro.leetcode.daily.模拟;

/**
 * @author cro
 * @description https://leetcode.cn/problems/one-away-lcci/
 */
public class Q0105一次编辑 {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            // 计算两个字符串的长度
            int firLen = first.length();
            int secLen = second.length();
            // 较长的作为基准 保证first是最长的
            String tmp = null;
            if (secLen > firLen) {
                tmp = first;
                first = second;
                second = tmp;
                firLen = first.length();
                secLen = second.length();
            }
            // 如果两个字符串长度差异超过2 一定不满足条件
            if (firLen - secLen > 1) return false;
            // 双指针
            int i = 0;
            int j = 0;
            // 记录修改次数
            int modCount = 0;
            while (i < firLen && j < secLen) {
                if (modCount > 1) return false;
                // 遇到相同的位置 i j 往下移动，不用修改
                if (first.charAt(i) == second.charAt(j)) {
                    i++;
                    j++;
                } else if (firLen == secLen) {
                    // 如果两个字符不相同
                    // 两种情况
                    // 1. 两个字符串长度相等，那么只能替换这个字符，i j再往下
                    i++;
                    j++;
                    modCount++;
                } else {
                    // 两个字符串长度不相等 先考虑把这个字符加入，再往下对比（因为只能改一次，如果这里添加后还是不对 说明修改次数一定大于一次）
                    i++;
                    modCount++;
                }
            }
            return modCount > 1 ? false : true;

        }
    }
}
