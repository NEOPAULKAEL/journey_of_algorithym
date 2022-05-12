package com.cro.leetcode.daily.二叉树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cro
 * @description https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class Q297序列化反序列化二叉树层级 {

    public class Codec {
        StringBuilder sb;
        public static final String SEP = ",";
        public static final String NULL = "#";


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            // 层级遍历使用队列存放还没有遍历的元素
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(cur.val).append(SEP);
                // 这里就不判断空了 应为我们要记录空节点
                q.add(cur.left);
                q.add(cur.right);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            // 进行分割
            String[] split = data.split(SEP);
            // 迭代还原树
            return deserialize(split);
        }

        public TreeNode deserialize(String[] nodes) {
            // 一个队列存放的都是根节点
            Queue<TreeNode> q = new LinkedList<>();
            // 构建根节点
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            q.offer(root);
            for (int i = 1; i < nodes.length; ) {
                // 拿出根节点
                TreeNode node = q.poll();
                // 构造左节点
                String left = nodes[i++];
                if (!NULL.equals(left)) {
                    node.left = new TreeNode(Integer.parseInt(left));
                    q.offer(node.left);
                } else {
                    node.left = null;
                }
                // 构造右节点
                String right = nodes[i++];
                if (!NULL.equals(right)) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    q.offer(node.right);
                } else {
                    node.right = null;
                }
            }
            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
