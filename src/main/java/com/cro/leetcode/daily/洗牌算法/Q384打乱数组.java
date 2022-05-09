package com.cro.leetcode.daily.洗牌算法;

import java.util.Random;

/**
 * @author cro
 * @description https://leetcode-cn.com/problems/shuffle-an-array/
 */
public class Q384打乱数组 {
    class Solution {
        int[] nums;
        Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        /**
         * 重点 确保每个地方都能被交换 且不是无效交换
         * 1 .... [1,n)
         * 2 .... [2,n)
         * ....
         * i .... [i,n)
         * n = length
         *
         * @return
         */
        public int[] shuffle() {
            int n = nums.length;
            if (n == 0) return null;
            int[] res = nums.clone();
            for (int i = 0; i < n; i++) {
                // 交换 i 位置 范围 i-n之间的一个随机位置
                // 和 i 交换的位置 范围 i-n 随机一个值
                // Math.random() 产生0-1之间的随机数
                // * (n-i) --> [0,n-i)
                // + i --> [i,n)
//                int j = (int) ((Math.random() * (n - i)) + i);
                int j = i + random.nextInt(n-i);
                swap(res, i, j);
            }
            return res;
        }

        /**
         * 交换两个位置
         *
         * @param i 位置1
         * @param j 位置2
         */
        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
