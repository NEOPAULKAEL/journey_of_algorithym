package com.cro.leetcode.daily.单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * 单调栈
 * 难点 ： 此问题是环形数组，最后一个元素需要重回起点再搜索一圈
 * 解决方法： 将数组长度翻倍
 * i%n
 *
 * @author cro
 * @description https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class Q503下一个更大的元素II {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            // 栈
            Stack<Integer> stack = new Stack<>();
            // 存放下一个比当前值大的数映射
            int[] res = new int[n];
            // 多循环一次
            // 下标 % 长度 可以确保每个元素都环形遍历了一次
            for (int i = 2 * n - 1; i >= 0; i--) {
                //如果栈不为空，且当前值比栈顶元素大
                if (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                    // 丢弃栈顶的元素
                    stack.pop();
                }
                // 栈中如果还剩元素 那么就是下一个最大的值
                res[i % n] = stack.isEmpty() ? -1 : stack.peek();
                // 当前元素压入栈中
                stack.push(nums[i % n]);
            }
            return res;
        }
    }
}
