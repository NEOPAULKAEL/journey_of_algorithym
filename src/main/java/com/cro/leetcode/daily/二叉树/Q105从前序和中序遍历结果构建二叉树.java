package com.cro.leetcode.daily.二叉树;

import java.util.HashMap;

/**
 * 构建篇 2
 * <a href="https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247496574&idx=1&sn=87d6f6bb23c7bdc30828797a361ac8c1&scene=21#wechat_redirect">https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247496574&idx=1&sn=87d6f6bb23c7bdc30828797a361ac8c1&scene=21#wechat_redirect</a>
 *
 * @author cro
 * @description https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Q105从前序和中序遍历结果构建二叉树 {
    class Solution {
        HashMap<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 由于题目中给定树没有重复值 可以用hashmap把inorder的索引存起来 以免遍历寻找
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1);
        }

        public TreeNode build(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd) {
            // base case
            if (preStart > preEnd || inStart > inEnd) return null;
            // 构建根节点
            TreeNode rootNode = new TreeNode(preorder[preStart]);
            // 根节点的值在inorder中的位置
            Integer index = map.get(rootNode.val);
            // 根据inorder 可以得到， 根节点左边 是 左子树的长度 --> index - inStart
            // 根节点的右边 是右子树的长度
            int leftSize = index - inStart;

            // 构建左子树
            rootNode.left = build(preorder, preStart + 1, leftSize + preStart,
                    inorder, inStart, index - 1);
            // 构建右子树
            rootNode.right = build(preorder, leftSize + preStart + 1, preEnd,
                    inorder, index + 1, inEnd);
            return rootNode;
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
