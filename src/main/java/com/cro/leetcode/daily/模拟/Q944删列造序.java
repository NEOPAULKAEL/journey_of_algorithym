package com.cro.leetcode.daily.模拟;

/**
 * @author cro
 * @description https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */
public class Q944删列造序 {
    class Solution {
        // 时间复杂度 O(n*m) n 字符串长度 m数组长度
        public int minDeletionSize(String[] strs) {
            // 列数 = 字符串长度
            int cols = strs[0].length();
            int rows = strs.length;
            // 记录需要删除的列数
            int count = 0;
            // 每一个列
            for (int i = 0; i < cols; i++) {
                // 取出每一个字符串当前位置 （列）
                for (int j = 1; j < rows; j++) {
                    // 如果不是按照升序排列 即后一位比前一位大（char值）
                    if (strs[j-1].charAt(i) > strs[j].charAt(i)){
                        // 一列有一个位置不满足 不用再往下了
                        count++;
                        break;
                    }
                }
            }
            return count;
        }
    }
}
