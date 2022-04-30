package com.cro.leetcode.daily.单调栈;

import java.util.Stack;

/**
 * 单调栈
 *
 * @author cro
 * @description https://leetcode-cn.com/problems/daily-temperatures/
 */
public class Q739每日温度 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            // stack 中存放的是温度值下标
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;
        }
    }
}
