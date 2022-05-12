package com.cro.leetcode.daily.二叉树;

import java.util.HashMap;

/**
 * @author cro
 * @description https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Q106从中序和后序遍历结果构建二叉树 {
    class Solution {
        HashMap<Integer, Integer> map;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            // 老样子 先缓存中序的结果
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(inorder, 0, inorder.length-1,
                    postorder, 0, postorder.length -1);

        }
        public TreeNode build(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd){
            // base case
            if (inStart > inEnd || postStart > postEnd) return null;
            // 构建根节点 后序遍历 - 根节点在最后
            TreeNode root = new TreeNode(postorder[postEnd]);
            // 找到根节点在中序遍历中的索引
            Integer index = map.get(root.val);
            /* 后序遍历
            * 根节点在最后
            * 左节点在最前面 -->postStart ~ postEnd -rightSize -1
            * 右节点在中间 --> postEnd - rightSize ~ postEnd -1
            * */
            // 得到右子树的长度
            int rightSize = inEnd - index;
            // 构建右子树
            root.right = build(inorder, index + 1, inEnd,
                    postorder, postEnd - rightSize, postEnd -1);
            // 构建左子树
            root.left = build(inorder, inStart, index - 1,
                    postorder, postStart, postEnd -rightSize -1);
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
