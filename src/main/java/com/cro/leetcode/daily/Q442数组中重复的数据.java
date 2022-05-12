package com.cro.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 * 数组范围[1-n]
 * 要求 空间复杂度O(N) 时间复杂度1
 * 数组中的数有可能出现1次到两次
 * @author cro
 * @description
 */
public class Q442数组中重复的数据 {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                // 利用数组中的值
                // 遍历到的元素值 [1-N]之间，遍历nums[i]将他的值作为下标去访问
                // 有可能遍历到的元素已经是负数了 所以要求一个绝对值
                int index = Math.abs(nums[i]) - 1;
                // 如果这个时候拿到的是正数，说明这个位置还没有被访问过
                if (nums[index] >=0){
                    // 标记这个位置 设为负值
                    nums[index] = -nums[index];
                }else {
                    // 如果是负数，说明这个值已经访问过，当前值出现了两次 放入res
                    res.add(index + 1);
                }
            }
            return res;
        }
    }
}
