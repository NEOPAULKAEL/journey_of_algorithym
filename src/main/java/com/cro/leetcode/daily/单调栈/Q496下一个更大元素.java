package com.cro.leetcode.daily.单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author cro
 * @description
 */
public class Q496下一个更大元素 {
    public static void main(String[] args) {
        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};
        Solution s = new Solution();
        s.nextGreaterElement(n1, n2);

    }
    static class Solution {
        // 暴力解法
        public int[] nextGreaterElementForce(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j <= nums2.length; ) {

                    // 找到nums2中该元素的位置
                    while (j<nums2.length && nums2[j] != nums1[i]){
                        j++;
                    }

                    // 如果后续元素更小 则遍历下一个位置
                    while (j<nums2.length && nums2[j] < nums1[i]){
                        j++;
                    }
                    // 遍历到末尾
                    if (j == nums2.length) {
                        res[i] = -1;
                        break;
                    }
                    // 如果没有遍历到末尾结束了 找到第一个更大的了
                    res[i] = nums2[j];
                }
            }
            return res;
        }
        // 单调栈
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            // 建立 栈 和 存放结果的map
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            // 遍历nums2
            for (int i = 1; i < nums2.length ; i++) {
                // 栈不为空 将当前元素与栈中元素比较
                // 如果当前元素大于栈顶元素 则这个数是栈顶元素的下一个最大的数
                // while循环 map中存放的是所有之前栈中数的更大数
                // 当遇到更大的 就保留这个数
                while (!stack.isEmpty() && nums2[i] > stack.peek()){
                    map.put(stack.pop(), nums2[i]);
                }
                // 当前元素放入考察栈中
                stack.push(nums2[i]);
            }
            while (!stack.isEmpty()){
                map.put(stack.pop(), -1);
            }
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = map.get(nums1[i]);
            }
            return nums1;
        }
    }
}
