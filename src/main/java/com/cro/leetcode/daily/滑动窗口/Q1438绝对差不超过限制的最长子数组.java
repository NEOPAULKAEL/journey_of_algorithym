package com.cro.leetcode.daily.滑动窗口;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 滑动窗口
 * @author cro
 * @description https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
public class Q1438绝对差不超过限制的最长子数组 {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            // 用两个双端队列记录最大值和最小值
            Deque<Integer> minQue = new ArrayDeque<>();
            Deque<Integer> maxQue = new ArrayDeque<>();

            int l=0,r=0,res=0;
            while (  r<nums.length) {
                // 如果队列不为空 当前值小于最小值队列中记录的值
                while (!minQue.isEmpty() && nums[r] < minQue.peekLast()){
                    // 弹出比当前值大的值
                    minQue.pollLast();
                }
                while (!maxQue.isEmpty() && nums[r] > maxQue.peekLast()){
                    // 弹出比当前值小的值
                    maxQue.pollLast();
                }
                // 当前值加入队列中
                minQue.add(nums[r]);
                maxQue.offer(nums[r]);
                // 移动指针
                r++;
                // 如果最大和最小值超过limit 缩小窗口
                while (maxQue.peek() - minQue.peek() > limit){
                    if (maxQue.peekFirst() == nums[l]) maxQue.removeFirst();
                    if (minQue.peekFirst() == nums[l]) minQue.removeFirst();
                    // 移动左指针 收缩窗口
                    l++;
                }
                // 记录最大长度
                res = Math.max(r-l, res);
            }
            return res;

        }
    }
}
