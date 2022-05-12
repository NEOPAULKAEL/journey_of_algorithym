package com.cro.leetcode.daily.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 无法恢复出来原始二叉树!
 *<a href="https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247496574&idx=1&sn=87d6f6bb23c7bdc30828797a361ac8c1&scene=21#wechat_redirect">https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247496574&idx=1&sn=87d6f6bb23c7bdc30828797a361ac8c1&scene=21#wechat_redirect</a>
 * @author cro
 * @description https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class Q889根据前序和后序遍历构建二叉树 {
    class Solution {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            // 缓存postOrder
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        public TreeNode build(int[] preorder, int preStart, int preEnd,
                              int[] postorder, int postStart, int postEnd) {
            // base case
            if (preStart > preEnd ) return null;
            if (preStart == preEnd) return new TreeNode(preorder[preStart]);
            //
            int rootVal = preorder[preStart];
            // pre 第二个元素是左节点
            int leftRootVal = preorder[preStart + 1];
            // 找到在后序遍历中的索引值
            int index = map.get(leftRootVal);
            // 左子树的长度的以确定
            int leftSize = index - postStart + 1;
            // 找到根节点
            TreeNode root = new TreeNode(rootVal);
            // 构建左子树 preStart + 1 ~ preStart + leftSize + 1
            root.left = build(preorder, preStart + 1, preStart + leftSize,
                    postorder, postStart, index);
            // 构建右子树 preStart + index + 2, preEnd
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                    postorder, index + 1, postEnd - 1);
            return root;
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
