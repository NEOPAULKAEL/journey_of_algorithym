package com.cro.leetcode.daily.二叉树;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author cro
 * @description https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class Q297序列化反序列化二叉树前序 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public class Codec {
        StringBuilder sb;
        public static final String SEP = ",";
        public static final String NULL = "#";


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }
        public void serialize(TreeNode node,StringBuilder sb){
            // 如果node是空节点
            if (node == null){
                // 注意添加分隔符 因为这里不是结束 有可能只是一边的子树遍历完了
                sb.append(NULL).append(SEP);
                return;
            }
            // 非空节点 记录值，加入分隔符
            // 前序位置
            sb.append(node.val).append(SEP);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // 进行分割
            String[] split = data.split(",");
            // 用链表装起来 方便操作
            LinkedList<String> nodes = new LinkedList<>();
            Collections.addAll(nodes, split);
            // 递归还原树
            return deserialize(nodes);
        }
        public TreeNode deserialize(LinkedList<String> nodes){
            // 如果树是空的，返回
            if (nodes.isEmpty()) return null;
            // 树不是空的 此时链表的第一个 就是一个根节点
            String first = nodes.removeFirst();
            // 如果第一个是# 说明这是一个叶子节点
            if (NULL.equals(first)) return null;
            TreeNode firstNode = new TreeNode(Integer.parseInt(first));
            // 再去往下遍历
            firstNode.left = deserialize(nodes);
            firstNode.right = deserialize(nodes);
            return firstNode;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
