package com.cro.leetcode.daily;

/**
 * @author cro
 * @description https://leetcode.cn/problems/maximum-subarray/
 */
public class Q53最大子数组和 {
    class SolutionOld {
        public int maxSubArray(int[] nums) {
            // 初始化取第一个值作为最大值
            // dp[] 含义 ： 以nums[i]作为结尾的最大子数组和
            int dp[] = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                // 有两种情况
                // 因为是连续的最大子数和
                // 1.只选择当前的数 从新开始
                // 2.选择加入之前的结果
                dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            }
            // 遍历dp数组找出最大值
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
    // 优化
    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums.length == 0 ) return 0;
            // 初始化取第一个值作为最大值
            // dp[] 含义 ： 以nums[i]作为结尾的最大子数组和
            int dp_0 = nums[0],dp_1 = 0,res = dp_0;
            for (int i = 1; i < nums.length; i++) {
                // 因为dp[i]之和dp[i-1]有关
                dp_1 = Math.max(dp_0+nums[i], nums[i]);
                dp_0 = dp_1;
                res = Math.max(res, dp_1);
            }
            return res;
        }
    }

}
