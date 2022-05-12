package com.cro.leetcode.daily.二叉树;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 利用搜索二叉树左子树一定比右子树小的特性，可以不用序列化空值，以此减少复杂度
 *
 * @author cro
 * @description https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class Q449序列化和反序列化搜索二叉树利用特性 {


    public class Codec {
        public static final String SEP = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            traversal(sb, root);
            return sb.toString();
        }

        public void traversal(StringBuffer sb, TreeNode node) {
            if (node == null) {
                return;
            }
            sb.append(node.val).append(SEP);
            traversal(sb, node.left);
            traversal(sb, node.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] split = data.split(SEP);
            LinkedList<String> nodes = new LinkedList<>();
            Collections.addAll(nodes, split);
            return deserialize(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode deserialize(LinkedList<String> nodes, int min, int max) {
            if (nodes.isEmpty()) return null;
            int rootVal = Integer.parseInt(nodes.getFirst());
            // 根节点的范围限制在 (min, max) 之间
            if (rootVal < min || rootVal > max) {
                return null;
            }
            // 取出根节点
            nodes.removeFirst();
            TreeNode root = new TreeNode(rootVal);
            // 左子树都比根节点小 所以最大值就是根节点的值
            root.left = deserialize(nodes, min, rootVal);
            // 右子树都比根节点大 所以最小值就是根节点的值
            root.right = deserialize(nodes, rootVal, max);
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
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
}
