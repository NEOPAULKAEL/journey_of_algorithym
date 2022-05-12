package com.cro.leetcode.daily.二叉树;

/**
 * 构建篇 1
 * <a href="https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247496574&idx=1&sn=87d6f6bb23c7bdc30828797a361ac8c1&scene=21#wechat_redirect">https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247496574&idx=1&sn=87d6f6bb23c7bdc30828797a361ac8c1&scene=21#wechat_redirect</a>
 * @author cro
 * @description https://leetcode.cn/problems/maximum-binary-tree/
 */
public class Q654最大二叉树 {


    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums.length == 0) return null;
            return build(nums, 0, nums.length);
        }
        public TreeNode build(int[] nums, int lo, int hi){
            if (lo > hi) return null;
            // nums中还有元素
            // 遍历找到最大值 记录索引
            int max = Integer.MIN_VALUE;
            int maxInd = -1;
            for (int i = lo; i < hi; i++) {
                if (nums[i]>max){
                    max = nums[i];
                    maxInd = i;
                }
            }
            // 构建这个节点
            TreeNode node = new TreeNode(nums[maxInd]);
            // 构建左子树
            node.left = build(nums, lo, maxInd - 1);
            // 构建右子树
            node.right = build(nums, maxInd + 1, hi);
            return node;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
